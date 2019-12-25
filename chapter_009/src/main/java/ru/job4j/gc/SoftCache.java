package ru.job4j.gc;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для хранения кэша в оперативной памяти
 */
public class SoftCache {
    private Map<String, SoftReference<String>> map;
    private String filePath;

    public SoftCache(String filePath) {
        this.filePath = filePath;
        this.map = new HashMap<>();
    }

    public String getCash(String key) {
        SoftReference<String> cach = map.get(key);
        if (cach == null) {
            String fileCach = null;
            try {
                fileCach = Files.readString(Paths.get(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            cach = new SoftReference<>(fileCach);
            map.put(key, cach);
        }
        return cach.get();
    }

    public static void main(String[] args) {
        String filePath1 = new File("Names.txt").getAbsolutePath();
        String filePath2 = new File("Address.txt").getAbsolutePath();
        SoftCache softCache1 = new SoftCache(filePath1);
        SoftCache softCache2 = new SoftCache(filePath2);
        System.out.println(softCache1.getCash("Names.txt"));
        System.out.println(softCache2.getCash("Address.txt"));
    }
}
