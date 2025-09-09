package notifications;

public interface Template {
    String applyTemplate(String message);
    void setStyle(String style);
}