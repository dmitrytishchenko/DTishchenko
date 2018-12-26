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
        List<String> list = new ArrayList<>(Arrays.asList(depart));
        list.sort(new Comparator<String>() {
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
        });
        return list.toArray(new String[list.size()]);
//        Set<String> descendingSet = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int result = 0;
//                if (o1.length() > o2.length()) {
//                    result = 1;
//                } else if (o1.length() < o2.length()) {
//                    result = -1;
//                } else if (o1.length() == o2.length()) {
//                    int min = Math.min(o1.length(), o2.length());
//                    for (int i = 0; i < min; i++) {
//                        if (o1.charAt(i) != o2.charAt(i)) {
//                            result = o2.compareTo(o1);
//                            break;
//                        }
//                    }
//                }
//                return result;
//            }
//        });
//        return descendingSet.toArray(new String[descendingSet.size()]);

    }
}
