package ru.job4j.gc;

import java.io.File;
import java.io.IOException;
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
                fileCach = Files.readString(Paths.get(filePath + File.separator + key));
            } catch (IOException e) {
                e.printStackTrace();
            }
            cach = new SoftReference<>(fileCach);
            map.put(key, cach);
        }
        return cach.get();
    }

    public static void main(String[] args) {
        SoftCache softCache = new SoftCache("C:\\projects\\DTishchenko\\chapter_009\\src\\main\\java\\ru\\job4j\\gc\\");
        System.out.println(softCache.getCash("Names.txt"));
        System.out.println(softCache.getCash("Address.txt"));
    }
}
