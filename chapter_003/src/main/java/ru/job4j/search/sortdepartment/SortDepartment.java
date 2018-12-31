package ru.job4j.search.sortdepartment;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

public class SortDepartment {

    private Set<String> set = new TreeSet<>();
    private Set<String> descendingSet = new TreeSet<>();

    class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = 0;
            String[] mas1 = o1.split("\\\\");
            String[] mas2 = o2.split("\\\\");
            int minim = Math.min(mas1.length, mas2.length);
            for (int i = 0; i < minim; i++) {
                if (!mas1[i].equals(mas2[i])) {
                    result = mas2[i].compareTo(mas1[i]);
                    break;
                }
            }
            if (result == 0) {
                if (mas1.length > mas2.length) {
                    result = 1;
                } else {
                    result = -1;
                }
            }
            return result;
        }
    }

    public String[] sort(String[] depart) {
        return this.set.toArray(new String[this.set.size()]);
    }

    public String[] add(String[] depart) {
        for (String value : depart) {
            String[] split = value.split("\\\\");
            StringBuilder builder = new StringBuilder();
            for (String s : split) {
                builder = builder.append(s);
                set.add(builder.toString());
                descendingSet.add(builder.toString());
                builder = builder.append("\\");
            }
        }
        return depart;
    }

    public String[] reverseSort(String[] depart) {
        Set<String> descendingSet = new TreeSet<>(new Comp());
        for (String s : depart) {
            descendingSet.add(s);
        }
        return descendingSet.toArray(new String[descendingSet.size()]);
    }
}

