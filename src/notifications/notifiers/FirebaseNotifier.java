package notifications.notifiers;

public class FirebaseNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[Firebase] Enviando notificación push a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("Notificación push enviada exitosamente via Firebase");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[Firebase] Verificando conexión API...");
        return true;
    }
}