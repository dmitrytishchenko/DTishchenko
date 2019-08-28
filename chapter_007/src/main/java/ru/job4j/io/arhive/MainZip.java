package ru.job4j.io.arhive;

public class MainZip {
    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip();
        zip.pack(zip.seekBy(args1.directory(), args1.exclude()), args1.output());
        System.out.println(args1.output().getAbsolutePath());
    }
}
