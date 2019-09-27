package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Наша программа должна запускаться в различном окружении. Например, разные базы данных, разные пути хранения.
 * Все эти настройки нужно хранить вне кода программы. Это позволяет изменять настройки и не трогать собранную программу.
 * Файл настроек должен содержать пары ключ-знания. Ключ-значения должны быть разделены символов равно
 * app.properties
 * ## PostgreSQL
 * hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
 * hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio
 * hibernate.connection.driver_class=org.postgresql.Driver
 * hibernate.connection.username=postgres
 * hibernate.connection.password=password
 * В этом задании нужно реализовать класс Config.
 * package ru.job4j.io;
 * import java.util.HashMap;
 * import java.util.Map;
 * public class Config {
 * private final String path;
 * private final Map<String, String> values = new HashMap<String, String>();
 * public Config(final String path) {
 * this.path = path;
 * }
 * public void load() {
 * }
 * public String value(String key) {
 * throw new UnsupportedOperationException("Don't impl this method yet!");
 * }
 * }
 * Метод load - должен считать все ключи в карту values. Важно в файле могут быть пустые строки и комментарии их нужно пропускать.
 * Для считывания файлов нужно использовать
 * import java.io.BufferedReader;
 * import java.io.FileReader;
 * Давайте переопределим метод toString и выведем все содержимое файла.
 * package ru.job4j.ru.job4j.io;
 * import java.io.BufferedReader;
 * import java.io.FileReader;
 * import java.util.HashMap;
 * import java.util.Map;
 * import java.util.StringJoiner;
 * public class Config {
 * private final String path;
 * private final Map<String, String> values = new HashMap<String, String>();
 * public Config(final String path) {
 * this.path = path;
 * }
 * public void load() {
 * }
 * public String value(String key) {
 * throw new UnsupportedOperationException("Don't impl this method yet!");
 * }
 *
 * @Override public String toString() {
 * StringJoiner out = new StringJoiner(System.lineSeparator());
 * try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
 * read.lines().forEach(out::add);
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * return out.toString();
 * }
 * public static void main(String[] args) {
 * System.out.println(new Config("app.properties"));
 * }
 * }
 * Файл app.properties лежит в корне проекта с:\projects\job4j\app.properties
 * Вывод
 * Примечания. Для работы с потоками ввода-вывода нужно использовать конструкцию try-with-resources.
 * Задание.
 * 1. Реализуйте метод load по аналогии с методом toString. Метод load должен загружать
 * пару ключ-значение в Map values.
 * 2. Реализуйте метод value(String key) он должен возвращать значение ключа.
 * 3. Напишите тест ConfigTest.
 */
public class ConfigTest {
    @Test
    public void testUserNameAndPassword() {
        Config config = new Config(Config.class.getClassLoader().getResource("app.properties").getFile());
        config.load();
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
    }
}
