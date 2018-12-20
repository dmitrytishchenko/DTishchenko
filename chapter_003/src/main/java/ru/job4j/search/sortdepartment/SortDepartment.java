package ru.job4j.search.sortdepartment;

import java.util.*;

public class SortDepartment {
    public String[] sort(String[] depart) {
        Arrays.sort(depart);
        return depart;
    }

    public String[] reverseSort(String[] depart) {
        Arrays.sort(depart);
        List<String> list = new ArrayList<>();
        for (String s : depart) {
            list.add(s);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int left = s1.length();
                int right = s2.length();
                int minimal = Math.min(left, right);
                for (int i = 0; i < minimal; i++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if (c1 != c2) {
                        return c2 - c1;
                    }
                }
                return left - right;
            }
        });
        return list.toArray(new String[list.size()]);
    }
}
