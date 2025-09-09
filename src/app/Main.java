package app;

import notifications.NotificationSystem;
import notifications.factories.*;

public class Main {
    public static void main(String[] args) {
        // Configuración desde system externo
        String plataforma = "sms"; // email, sms, push
        String proveedor = "twilio"; // sendgrid, twilio, firebase

        NotificationFactory factory = getFactory(plataforma, proveedor);

        NotificationSystem system = new NotificationSystem(factory);
        system.initialize();

        // Configurar con parámetros específicos
        String[] configEmail = {"SG-123456", "miempresa.com"};
        system.configureSystem(configEmail);

        System.out.println("\n=== Probando Plantilla ===");
        system.testTemplate("Su pedido ha sido enviado");

        System.out.println("\n=== Enviando Notificación ===");
        system.sendNotification("cliente@email.com", "Su orden #1234 está lista");
    }

    private static NotificationFactory getFactory(String platform, String supplier) {
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