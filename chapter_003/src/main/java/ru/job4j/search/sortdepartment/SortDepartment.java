package ru.job4j.search.sortdepartment;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

public class SortDepartment {
    private Set<String> set = new TreeSet<>();

    public String[] sort(String[] depart) {
        for (String s : depart) {
            this.set.add(s);
        }
        return set.toArray(new String[set.size()]);
    }

    public Set<String> fullMassiv(String[] depart) {
        for (String s : depart) {
            String[] dep = s.split("\\\\");
            for (String mas : dep) {
                this.set.add(mas);
            }
        }
        return set;
    }

    public String[] reverseSort(String[] depart) {
        Set<String> descendingSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                if (o1.length() > o2.length()) {
                    result = 1;
                } else if (o1.length() < o2.length()) {
                    result = -1;
                } else if (o1.length() == o2.length()) {
                    int min = Math.min(o1.length(), o2.length());
                    for (int i = 0; i < min; i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            result = o2.compareTo(o1);
                            break;
                        }
                    }
                }
                return result;
            }
        });
        return descendingSet.toArray(new String[descendingSet.size()]);
    }
}
