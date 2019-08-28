package ru.job4j.io.arhive;

import java.io.File;

public class Args {
    private String directory;
    private File output;
    private String exclude;

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-d")) {
                this.directory = args[++i];
            } else if (args[i].contains("-e")) {
                String[] mas = args[++i].split("\\.");
                exclude = mas[mas.length - 1];
            } else if (args[i].contains("-o")) {
                String[] mas = args[++i].split(" ");
                this.output = new File(mas[mas.length - 1]);
            }
        }
    }

    public String directory() {
        return this.directory;
    }

    public String exclude() {
        return exclude;
    }

    public File output() {
        return this.output;
    }
}
