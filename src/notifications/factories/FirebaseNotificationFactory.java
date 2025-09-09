package notifications.factories;

import config.Configurator;
import config.FirebaseConfigurator;
import notifications.notifiers.FirebaseNotifier;
import notifications.notifiers.Notifier;
import notifications.templates.FirebaseTemplate;
import notifications.templates.Template;

public class FirebaseNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new FirebaseNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new FirebaseConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new FirebaseTemplate();
    }
}