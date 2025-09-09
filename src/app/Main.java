package app;

import notifications.NotificationFactory;
import notifications.NotificationSystem;

public class Main {
    public static void main(String[] args) {
        // Configuración desde system externo
        String plataforma = "email"; // email, sms, push
        String proveedor = "sendgrid"; // sendgrid, twilio, firebase

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
        return switch (platform + "-" + supplier) {
            case "email-sendgrid" -> new SendGridFactory();
            case "sms-twilio" -> new TwilioFactory();
            case "push-firebase" -> new FirebaseFactory();
            default -> throw new IllegalArgumentException("Combinación no soportada");
        };
    }
}