package app;

import notifications.NotificationSystem;
import notifications.factories.*;

public class Main {
    public static void main(String[] args) {
        // Configuración desde notificationSystem externo
        String plataform = "email"; // email, sms, push
        String supplier = "sendgrid"; // sendgrid, twilio, firebase || mailchimp, nexmo, onesignal
        boolean successfulSent = false;

        while (!successfulSent) {
            NotificationFactory factory = getPreferredFactory(plataform, supplier);

            NotificationSystem notificationSystem = new NotificationSystem(factory);
            notificationSystem.initialize();

            // Configurar con parámetros específicos
            String[] configEmail = {"SG-123456", "miempresa.com"};
            notificationSystem.configureSystem(configEmail);

            System.out.println("\n=== Probando Plantilla ===");
            notificationSystem.testTemplate("Su pedido ha sido enviado");

            System.out.println("\n=== Enviando Notificación ===");

            // Sistema fallback en caso de que un proveedor no funcione
            successfulSent = notificationSystem.sendNotification(
                    "cliente@email.com",
                    "Su orden #1234 está lista"
            );
            if (!successfulSent) {
                supplier = switch (plataform.toLowerCase() + "-" + supplier.toLowerCase()) {
                    case "email-sendgrid" -> "mailchimp";
                    case "email-mailchimp" -> "sendgrid";
                    case "sms-twilio" -> "nexmo";
                    case "sms-nexmo" -> "twilio";
                    case "push-firebase" -> "onesignal";
                    case "push-onesignal" -> "firebase";
                    default -> throw new IllegalArgumentException("Combinación no soportada");
                };
            }
        }
    }

    private static NotificationFactory getPreferredFactory(String platform, String supplier) {
        return switch (platform.toLowerCase() + "-" + supplier.toLowerCase()) {
            case "email-sendgrid" -> new SendGridNotificationFactory();
            case "email-mailchimp" -> new MailChimpNotificationFactory();
            case "sms-twilio" -> new TwilioNotificationFactory();
            case "sms-nexmo" -> new NexmoNotificationFactory();
            case "push-firebase" -> new FirebaseNotificationFactory();
            case "push-onesignal" -> new OneSignalNotificationFactory();
            default -> throw new IllegalArgumentException("Combinación no soportada");
        };
    }
}