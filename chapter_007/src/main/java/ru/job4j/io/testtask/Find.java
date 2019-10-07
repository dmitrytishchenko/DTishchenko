package ru.job4j.io.testtask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public static void main(String[] args) {
        Keys keys = new Keys(args);
        SearchFile sf = new SearchFile();
        List<File> list = sf.getFile(keys.getDirectory());
        List<File> result = new ArrayList<>();
        for (File f : list) {
            if (sf.checkName(f, keys.getName())) {
                result.add(f);
            } else if (sf.checkFullName(f, keys.getFullName())) {
                result.add(f);
            } else if (sf.checkMask(f, keys.getMask())) {
                result.add(f);
            } else if (sf.checkRegex(f, keys.getRegex())) {
                result.add(f);
            }
            sf.writeFile(result, keys.getOutput());
        }
    }
}
// java -jar find.jar -d C:\projects\DTishchenko -n *.txt -m *.java -f Example -r \\W+[\\.]\\W+ -o log.txt
