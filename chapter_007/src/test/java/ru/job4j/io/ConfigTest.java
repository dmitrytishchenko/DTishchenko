package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void testUserNameAndPassword() {
        Config config = new Config("C:\\projects\\DTishchenko\\chapter_007\\src\\main\\resources\\app.properties");
        config.load();
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
    }
}