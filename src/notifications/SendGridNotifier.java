package notifications;

public class SendGridNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[SendGrid] Enviando email a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("Email enviado exitosamente via SendGrid");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[SendGrid] Verificando conexión API...");
        return true;
    }
}