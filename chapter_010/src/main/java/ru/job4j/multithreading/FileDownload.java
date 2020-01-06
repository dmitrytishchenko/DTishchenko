package ru.job4j.multithreading;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {

    public static void main(String[] args) {
        String file = args[0];
        String fileOut = args[1];
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {
            byte[] dataBuffer = new byte[1024];
            long size = 0;
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                size += bytesRead;
                long actualTime = 1000;
                int speed = Integer.parseInt(args[2]) * 1024;
                long expectedTime = size / speed;
                if (actualTime <= expectedTime) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println(dataBuffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
