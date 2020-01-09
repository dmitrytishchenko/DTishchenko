package ru.job4j.multithreading;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {
    private long timePause = 0;

    public void start(String inputFile, String outFile, int maxSpeed) {
        long startTime = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new URL(inputFile).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outFile)) {
            byte[] dataBuffer = new byte[1024];
            long size = 0;
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                size += bytesRead;
                long endTime = System.currentTimeMillis();
                long actualTime = endTime - startTime; //время скачивания одного килобайта
                long expectedTime = size / maxSpeed;
                if (actualTime > expectedTime) {
                    timePause = actualTime - expectedTime;
                    try {
                        Thread.sleep(timePause);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
