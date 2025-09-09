package notifications;

import config.Configurator;
import notifications.factories.NotificationFactory;
import notifications.notifiers.Notifier;
import notifications.templates.Template;

public class NotificationSystem {
    private final NotificationFactory factory;
    private Notifier notifier;
    private Configurator configurator;
    private Template template;

    public NotificationSystem(NotificationFactory factory) {
        this.factory = factory;
    }

    public void initialize() {
        this.notifier = factory.createNotifier();
        this.configurator = factory.createConfigurator();
        this.template = factory.createTemplate();
    }

    public void configureSystem(String[] parameters) {
        configurator.configurate(parameters);
        System.out.println("Configuración: " + configurator.getConfiguration());
    }

    public boolean sendNotification(String recipient, String message) {
        if (notifier.verifyConnection()) {
            String formattedMessage = template.applyTemplate(message);
            notifier.send(recipient, formattedMessage);
            return true;
        } else {
            System.out.println("Error: No hay conexión con el proveedor");
            return false;
        }
    }

    public void testTemplate(String message) {
        template.setStyle("urgente");
        String result = template.applyTemplate(message);
        System.out.println("Plantilla aplicada: " + result);
    }
}