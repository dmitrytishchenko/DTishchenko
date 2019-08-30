package ru.job4j.io;

import java.io.File;
import java.util.*;

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

