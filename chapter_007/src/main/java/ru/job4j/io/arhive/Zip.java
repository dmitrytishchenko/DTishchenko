package ru.job4j.io.arhive;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    List<File> seekBy(String root, String ext) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(root);
        data.add(file);
        while (!data.isEmpty()) {
            File f = data.poll();
            if (f.isDirectory()) {
                data.addAll(Arrays.asList(f.listFiles()));
            } else {
                String[] mas = f.getName().split("\\.");
                if (mas[mas.length - 1].contains(ext)) {
                    result.add(f);
                }
            }
        }
        return result;
    }

    public void pack(List<File> source, File target) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : source) {
                zipOut.putNextEntry(new ZipEntry(f.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zipOut.write(out.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packExample(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
