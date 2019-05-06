package ru.job4j.xmlxslt;

import java.io.InputStream;
import java.util.Properties;

/**
 * Config - объект содержащий настройки для подключения к базе
 */
public class Config {
    private final Properties values = new Properties();
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app1.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public String get(String key) {
        return this.values.getProperty(key);
    }
}
