package notifications.notifiers;

public class TwilioNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[Twilio] Enviando SMS a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("SMS enviado exitosamente via Twilio");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[Twilio] Verificando conexión API...");
        return true;
    }
}