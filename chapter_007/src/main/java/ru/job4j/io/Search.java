package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Файловая система представляет собой древовидную структуру. В модуле "Коллекции Про" рассматривался алгоритм обхода дерева.
 * Этот алгоритм обхода в ширину.
 * В этом задании нужно написать метод, который возвращает список всех файлов с конкретным расширением.
 * Метод должен заходить во всех каталоги.
 * Для этого нужно использовать алгоритм обхода дерева в ширину.
 * class Search {
 * List<File> files(String parent, List<String> exts);
 * }
 * String parent - это путь до каталога, с которого нужно осуществлять поиск.
 * List<String> exts - это расширения файлов, которые мы хотим получить.
 * В этой задаче нужно использовать методы.
 * File file = new File(path);
 * file.listFiles() - возвращает список всех каталогов и файлов находящихся в папке  file.
 * file.isDirectory() - проверяет, что файл является директорией.
 * file.getName() - возвращает имя файла с расширением.
 * В этой задаче нужно написать тесты. Для тестов нужно создать временную структуру с файлами.
 * Структуру нужно создавать в папке System.getProperty("java.io.tmpdir")
 * Здесь нельзя использовать FileVisitor. Это задание на работу с деревом каталогов.
 */
public class Search {
    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(parent);
        data.offer(file);
        while (!data.isEmpty()) {
            File f = data.poll();
            if (f.isDirectory()) {
                data.addAll(Arrays.asList(f.listFiles()));
            } else {
                if (check(f, exts)) {
                    result.add(f);
                }
            }
        }
        return result;
    }

    public List<File> files2(String parent, List<String> exts, List<File> result) {
        File file = new File(parent);
        if (file != null) {
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) {
                    files2(file1.getAbsolutePath(), exts, result);
                }
            }
        } else {
            if (check(file, exts)) {
                result.add(file);
            }
        }
        return result;
    }

    public boolean check(File file, List<String> exts) {
        Boolean result = false;
        for (String ext : exts) {
            if (file.getName().endsWith(ext)) {
                result = true;
            }
        }
        return result;
    }
}

