package ru.job4j.io.testtask;

import java.io.File;

public class Keys {
    private String directory;
    private String name;
    private String mask;
    private String fullName;
    private String regex;
    private File output;

    public Keys(String[] keys) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].contains("-d")) {
                this.directory = keys[++i];
            } else if (keys[i].contains("-n")) {
                String[] mas = keys[++i].split("\\.");
                this.name = mas[mas.length - 1];
            } else if (keys[i].contains("-m")) {
                String[] mas = keys[++i].split("\\.");
                this.mask = mas[mas.length - 1];
            } else if (keys[i].contains("-f")) {
                String[] mas = keys[++i].split("\\.");
                fullName = mas[mas.length - 1];
            } else if (keys[i].contains("-r")) {
                String[] mas = keys[++i].split(" ");
                regex = mas[mas.length - 1];
            } else if (keys[i].contains("-o")) {
                String[] mas = keys[++i].split(" ");
                this.output = new File(mas[mas.length - 1]);
            }
        }
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }

    public String getMask() {
        return mask;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRegex() {
        return regex;
    }

    public File getOutput() {
        return output;
    }
}
