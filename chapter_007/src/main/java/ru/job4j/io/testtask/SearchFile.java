package ru.job4j.io.testtask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFile {
    private List<File> result = new ArrayList<>();

    public List<File> getFile(String parentDir) {
        File file = new File(parentDir);
        if (file != null) {
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    getFile(f.getAbsolutePath());
                }
            } else {
                this.result.add(file);
            }
        }
        return this.result;
    }

    public boolean checkName(File file, String name) {
        boolean result = false;
        if (file.getName().equals(name)) {
            result = true;
        }
        return result;
    }

    public boolean checkFullName(File file, String name) {
        boolean result = false;
        if (file.getName().equals(name)) {
            result = true;
        }
        return result;
    }

    public boolean checkMask(File file, String ext) {
        boolean result = false;
        if (file.getName().endsWith(ext)) {
            result = true;
        }
        return result;
    }

    public boolean checkRegex(File file, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher mt = pattern.matcher(file.getName());
        return mt.matches();
    }

    public void writeFile(List<File> source, File target) {
        try (FileWriter fw = new FileWriter(target)) {
            int value;
            for (File f : source) {
                FileReader fr = new FileReader(f);
                while ((value = fr.read()) != -1) {
                    fw.write(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
