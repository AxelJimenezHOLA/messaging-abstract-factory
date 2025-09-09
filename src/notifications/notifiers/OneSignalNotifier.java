package notifications.notifiers;

public class OneSignalNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[OneSignal] Enviando notificación push a: " + recipient);
        System.out.println("Mensaje: " + message);
        System.out.println("Notificación push enviada exitosamente via OneSignal");
    }

    @Override
    public boolean verifyConnection() {
        System.out.println("[OneSignal] Verificando conexión API...");
        return true;
    }
}