package ru.job4j.multithreading;

public class MainDownload {
    public static void main(String[] args) {
        FileDownload fileDownload = new FileDownload();
        fileDownload.start(args[0], args[1], Integer.parseInt(args[2]));
    }
}
