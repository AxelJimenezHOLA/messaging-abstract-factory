package notifications.factories;

import config.Configurator;
import config.TwilioConfigurator;
import notifications.notifiers.Notifier;
import notifications.notifiers.TwilioNotifier;
import notifications.templates.Template;
import notifications.templates.TwilioTemplate;

public class TwilioNotificationFactory implements NotificationFactory {
    @Override
    public Notifier createNotifier() {
        return new TwilioNotifier();
    }

    @Override
    public Configurator createConfigurator() {
        return new TwilioConfigurator();
    }

    @Override
    public Template createTemplate() {
        return new TwilioTemplate();
    }
}