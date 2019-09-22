package ru.job4j.io.networke;

import java.io.InputStream;
import java.util.Properties;

public class ConfigSockets {
    private final Properties values = new Properties();

    public ConfigSockets() {
        init();
    }

    public void init() {
        try (InputStream in = ConfigSockets.class.getClassLoader().getResourceAsStream("socket.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
