package notifications;

public interface Notifier {
    void send(String recipient, String message);
    boolean verifyConnection();
}