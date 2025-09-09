package config;

public interface Configurator {
    void configurate(String[] parameters);
    String getConfiguration();
}