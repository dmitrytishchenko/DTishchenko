package ru.job4j.io.shildt;

import java.io.*;

public class Example {
    static String dirname = "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io\\shildt";

    public static void p(String s) {
        System.out.println(s);
    }

    public static class OnlyExt implements FilenameFilter {
        String ext;

        public OnlyExt(String ext) {
            this.ext = "." + ext;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    public static class OnlyExt2 implements FileFilter {
        String filter;

        public OnlyExt2(String filter) {
            this.filter = filter;
        }

        @Override
        public boolean accept(File pathname) {
            return pathname.getPath().equals(filter);
        }
    }

    public static void file() {
        File file = new File("C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io\\shildt");
        File file1 = new File("shildt", "Example");
        File file2 = new File("Example");
        String absolutePath = file2.getAbsolutePath();
        String path = file2.getPath();
        System.out.println(absolutePath);
        System.out.println(path);
        File file3 = new File(file, "Example.java");
        p("Имя файла: " + file3.getName());
        p("Абсолютный путь: " + file3.getAbsolutePath());
        p("Путь: " + file3.getPath());
        p("Родиткльский каталог: " + file3.getParent());
        p(file3.exists() ? "существует" : "не существует");
        p(file3.canRead() ? "доступен для чтения" : "не доступен для чтения");
        p(file3.canWrite() ? "доступен для записи" : "не доступен для записи");
        p(file3.isDirectory() ? "является каталогом" : "не является каталогом");
        p(file3.isFile() ? "является обычным файлом" : "не является обычным файлом");
        p(file3.isAbsolute() ? "является абсолютным" : "не является абсолютным");
        p("Последнее изменение в файле: " + file3.lastModified());
        p("Размер: " + file3.length() + "байт");
    }

    public static void dir() {
        String dirname = "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io\\shildt";
        File file = new File(dirname);
        if (file.isDirectory()) {
            System.out.println("Каталог " + dirname);
            String[] s = file.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "\\" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " является каталогом");
                } else {
                    System.out.println(s[i] + " является файлом");
                }
            }
        } else {
            System.out.println(dirname + " не является каталогом");
        }
    }

    public static void filter() {

        File file = new File(dirname);
        FilenameFilter only = new OnlyExt("java");
        String[] s = file.list(only);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public static void listFile() {

        File file = new File(dirname);
        File[] masf = file.listFiles();
        System.out.println(masf[0]);
        FilenameFilter only = new OnlyExt("java");
        File[] masf1 = file.listFiles(only);
        System.out.println(masf1[0]);
        File[] masf2 = file.listFiles(new OnlyExt2(dirname));
        System.out.println(masf2[0]);
    }

    public static void fis() {
        File file = new File(dirname);
        int size = 0;
        try (FileInputStream fis = new FileInputStream("C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io\\shildt\\Example.java");) {
            System.out.println("Общее количество доступных байтов: " + (size = fis.available()));
            int n = size / 40;
            System.out.println("Первые " + n + "байтов прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) {
                System.out.println((char) fis.read());
            }
            System.out.println("Все еще доступно: " + fis.available());
            System.out.println("Чтение следующих " + n + "байтов по очереди методом read(b[])");
            byte[] b = new byte[n];
            if (fis.read(b) != n) {
                System.err.println("Нельзя прочитать " + n + " ,байтов.");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("Все еще доступно: " + (size = fis.available()));
            System.out.println("Пропустить половину методом skip()");
            fis.skip(size / 2);
            System.out.println("Все еще доступно : " + fis.available());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fos() {
        String source = "Now is the time for all good men to come to the aid of their country and pay their due taxes";
        byte[] buffer = source.getBytes();
        try (FileOutputStream fos = new FileOutputStream(new File("Example.txt"))) {
            for (int i = 0; i < buffer.length; i++) {
                fos.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bais() {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte[] b = tmp.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ByteArrayInputStream bais2 = new ByteArrayInputStream(b, 0, 3);
    }

    public static void baos() {
        String tmp = "Эти данные должны быть выведены в массив";
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] b = tmp.getBytes();
            for (int i = 0; i < b.length; i++) {
                baos.write(b[i]);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void data() {
        File f = new File("Query.txt");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(f));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
            dos.writeBoolean(true);
            dos.writeDouble(97.5);
            dos.writeInt(12);
            boolean a = dis.readBoolean();
            double b = dis.readDouble();
            int c = dis.readInt();
            System.out.println(a + " " + b + " " + c);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void rand() {
        File file = new File("Query.txt");
        try (RandomAccessFile raf1 = new RandomAccessFile(file, "r");
             RandomAccessFile raf2 = new RandomAccessFile(file, "rw")) {
//            установка положение курсора в файле на 100 байт
            raf1.seek(100);
            raf2.seek(200);
//            запись во второй файл, начиная с 200 байта
            raf2.writeBytes("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        dir();
//        filter();
//        listFile();
//        fis();
//        fos();
//        bais();
//        baos();
//        data();
//rand();
    }


}
