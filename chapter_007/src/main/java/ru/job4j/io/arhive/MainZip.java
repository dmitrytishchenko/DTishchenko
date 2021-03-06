package ru.job4j.io.arhive;
/**
 * 1. Задана директория проекта, например: c:\project\job4j\
 * 2. В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
 * 3. Архив должен сохранять структуру проекта.
 * 4. Запуск проекта java -jar pack.jar -d c:\project\job4j\ -e *.java -o project.zip
 * java -jar pack.jar - Это собранный jar.
 * -d - directory - которую мы хотим архивировать
 * -e - exclude - исключить файлы *.xml
 * -o - output - во что мы архивируем.
 * У вас должен быть класс new Args(agrs)
 * с методами directory() excule() output();
 * 5. Для архивации использовать классы ZipOutputStream.java.
 * 6. Создайте класс. Zip.
 * в нем должно быть два методы
 * List<File> seekBy(String root, String ext)
 * void pack(List<File> sources, File target)
 * <p>
 * package ru.job4j;
 * import java.io.*;
 * import java.util.zip.ZipEntry;
 * import java.util.zip.ZipOutputStream;
 * public class Zip {
 * public void pack(File source, File target) {
 * try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
 * zip.putNextEntry(new ZipEntry(source.getPath()));
 * try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
 * zip.write(out.readAllBytes());
 * }
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * public static void main(String[] args) {
 * new Zip().pack(new File("./chapter_005/pom.xml"), new File("./chapter_005/pom.zip"));
 * }
 * }
 * Для тестирования кода в IDEA нужно прописать параметры запуска main метода
 * Run - Edit
 */
public class MainZip {
    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip();
        zip.pack(zip.seekBy(args1.directory(), args1.exclude()), args1.output());
        System.out.println(args1.output().getAbsolutePath());
    }
}
