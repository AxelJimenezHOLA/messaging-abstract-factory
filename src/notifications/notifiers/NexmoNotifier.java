package notifications.notifiers;

public class NexmoNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[Nexmo] Enviando SMS a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("SMS enviado exitosamente via Nexmo");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[Nexmo] Verificando conexión API...");
        return true;
    }
}