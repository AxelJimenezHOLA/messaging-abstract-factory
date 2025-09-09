package notifications.factories;

import config.Configurator;
import config.SendGridConfigurator;
import notifications.notifiers.Notifier;
import notifications.notifiers.SendGridNotifier;
import notifications.templates.SendGridTemplate;
import notifications.templates.Template;

public class SendGridNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new SendGridNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new SendGridConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new SendGridTemplate();
    }
}