package notifications.factories;

import config.Configurator;
import config.NexmoConfigurator;
import notifications.notifiers.NexmoNotifier;
import notifications.notifiers.Notifier;
import notifications.templates.NexmoTemplate;
import notifications.templates.Template;

public class NexmoNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new NexmoNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new NexmoConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new NexmoTemplate();
    }
}