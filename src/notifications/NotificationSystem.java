package notifications;

import config.Configurator;

public class NotificationSystem {
    private NotificationFactory factory;
    private Notifier notificator;
    private Configurator configurator;
    private Template template;

    public NotificationSystem(NotificationFactory factory) {
        this.factory = factory;
    }

    public void initialize() {
        this.notificator = factory.createNotificator();
        this.configurator = factory.createConfigurator();
        this.template = factory.createTemplate();
    }

    public void configureSystem(String[] parameters) {
        configurator.configurate(parameters);
        System.out.println("Configuración: " + configurator.getConfiguration());
    }

    public void sendNotification(String recipient, String message) {
        if (notificator.verifyConnection()) {
            String formattedMessage = template.applyTemplate(message);
            notificator.send(recipient, formattedMessage);
        } else {
            System.out.println("Error: No hay conexión con el proveedor");
        }
    }

    public void testTemplate(String message) {
        template.setStyle("urgente");
        String result = template.applyTemplate(message);
        System.out.println("Plantilla aplicada: " + result);
    }
}