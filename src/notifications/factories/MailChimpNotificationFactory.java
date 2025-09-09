package notifications.factories;

import config.Configurator;
import config.MailChimpConfigurator;
import notifications.notifiers.MailChimpNotifier;
import notifications.notifiers.Notifier;
import notifications.templates.MailChimpTemplate;
import notifications.templates.Template;

public class MailChimpNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new MailChimpNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new MailChimpConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new MailChimpTemplate();
    }
}