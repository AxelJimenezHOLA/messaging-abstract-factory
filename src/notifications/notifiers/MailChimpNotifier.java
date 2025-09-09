package notifications.notifiers;

public class MailChimpNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[MailChimp] Enviando email a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("Email enviado exitosamente via MailChimp");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[MailChimp] Verificando conexión API...");
        return true;
    }
}