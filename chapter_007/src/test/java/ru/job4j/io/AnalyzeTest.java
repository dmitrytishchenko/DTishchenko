package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Частой задаче в программировании является задача преобразования одного файла в другой.
 * Представим, что у нас есть файл регистрации событий сервера.
 * Он имеет следующий формат
 * TYPE date
 * Type - может иметь 4 значения 200, 300, 400, 500
 * Date - это время проверки 10:56:01 (формат часы:минуты:секунды)
 * Например server.log
 * 200 10:56:01
 * 200 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 * Давайте сделаем класс Analizy
 * package ru.job4j.io;
 * import java.io.FileOutputStream;
 * import java.io.PrintWriter;
 * public class Analizy {
 * public void unavailable(String source, String target) {
 * }
 * public static void main(String[] args) {
 * try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
 * out.println("15:01:30;15:02:32");
 * out.println("15:10:30;23:12:32");
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * }
 * <p>
 * Метод main - записывает текст в файл "unavailable.csv
 * Задание.
 * 1. Реализуйте метод unavailable.
 * source - имя файла лога
 * target - имя файла после анализа.
 * 2. Метод anavailable должен находить диапазоны, когда сервер не работал.
 * Сервер не работал. если status = 400 или 500.
 * Диапазон считается последовательность статусов 400 и 500
 * Например:
 * 200 10:56:01
 * 500 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 * тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02
 * Начальное время - это время когда статус 400 или 500. конечное время это когда статус меняется с 400 или 500 на 200 300.
 * 3. Результат анализа нужно записать в файл target.
 * Формат файла
 * начала периода;конец периода;
 * 4. Записать тесты.
 */
public class AnalyzeTest {
    @Test
    public void whenReadSourceThenWriteTarget() {
        Analyze analyze = new Analyze();
        String s;
        String serverLog = "200 10:56:01\n"
                + "500 10:57:01\n"
                + "400 10:58:01\n"
                + "200 10:59:01\n"
                + "500 11:01:02\n"
                + "200 11:02:02";
        String result = "";
        String parent = System.getProperty("java.io.tmpdir") + File.separator;
        File file = new File(parent + "Source");
        File file1 = new File(parent + "Target");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(serverLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String source = file.getAbsolutePath();
        String target = file1.getAbsolutePath();
        analyze.unavailable(source, target);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(target)));
            while ((s = reader.readLine()) != null) {
                result += s;
            }
            assertThat(result, is("10:57:01-10:59:0111:01:02-11:02:02"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}