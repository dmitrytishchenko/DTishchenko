package ru.job4j.search.sortdepartment;

import java.util.*;

public class SortDepartment {

    private Set<String> set = new TreeSet<>();
    class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = 0;
            int min = Math.min(o1.length(), o2.length());
            result = -o1.substring(0, min).compareTo(o2.substring(0, min));
            return result != 0 ? result : Integer.compare(o1.length(), o2.length());
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
                builder = builder.append("\\");
            }
        }
        return set.toArray(new String[set.size()]);
    }

    public String[] reverseSort(String[] depart) {
        Set<String> descendingSet = new TreeSet<>(new Comp());
        for (String s : depart) {
            descendingSet.add(s);
        }
        return descendingSet.toArray(new String[descendingSet.size()]);
    }
}

