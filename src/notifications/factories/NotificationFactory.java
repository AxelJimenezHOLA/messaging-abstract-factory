package notifications.factories;

import config.Configurator;
import notifications.notifiers.Notifier;
import notifications.templates.Template;

public interface NotificationFactory {
    Notifier createNotifier();

    Configurator createConfigurator();

    Template createTemplate();
}