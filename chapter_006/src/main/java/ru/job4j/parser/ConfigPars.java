package ru.job4j.parser;

import java.io.InputStream;
import java.util.Properties;

public class ConfigPars {
    private final Properties values = new Properties();

    public ConfigPars() {
        init();
    }

    public void init() {
        try (InputStream in = ConfigPars.class.getClassLoader().getResourceAsStream("app2.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
