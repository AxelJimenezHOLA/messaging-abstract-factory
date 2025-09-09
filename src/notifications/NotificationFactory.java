package notifications;

import config.Configurator;

public interface NotificationFactory {
    Notifier createNotificator();
    Configurator createConfigurator();
    Template createTemplate();
}