package notifications.templates;

public class FirebaseTemplate implements Template {
    private String style;

    @Override
    public String applyTemplate(String message) {
        return switch (style.toLowerCase()) {
            case "urgente" -> "[URGENTE] ";
            case "normal" -> "[Normal] ";
            default -> "";
        } + message;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
    }
}