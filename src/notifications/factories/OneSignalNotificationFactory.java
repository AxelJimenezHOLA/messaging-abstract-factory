package notifications.factories;

import config.Configurator;
import config.OneSignalConfigurator;
import notifications.notifiers.Notifier;
import notifications.notifiers.OneSignalNotifier;
import notifications.templates.OneSignalTemplate;
import notifications.templates.Template;

public class OneSignalNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new OneSignalNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new OneSignalConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new OneSignalTemplate();
    }
}