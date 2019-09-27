package ru.job4j.io.arhive;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
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
public class Zip {
    List<File> seekBy(String root, String ext) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(root);
        data.add(file);
        while (!data.isEmpty()) {
            File f = data.poll();
            if (f.isDirectory()) {
                data.addAll(Arrays.asList(f.listFiles()));
            } else {
                String[] mas = f.getName().split("\\.");
                if (mas[mas.length - 1].contains(ext)) {
                    result.add(f);
                }
            }
        }
        return result;
    }

    public void pack(List<File> source, File target) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : source) {
                zipOut.putNextEntry(new ZipEntry(f.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zipOut.write(out.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packExample(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
