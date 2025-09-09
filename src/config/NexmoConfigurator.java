package config;

public class NexmoConfigurator implements Configurator {
    private String apiKey;
    private String domain;

    @Override
    public void configurate(String[] parameters) {
        this.apiKey = parameters[0];
        this.domain = parameters[1];
    }

    @Override
    public String getConfiguration() {
        return "Nexmo - API Key: " + apiKey + ", Dominio: " + domain;
    }
}