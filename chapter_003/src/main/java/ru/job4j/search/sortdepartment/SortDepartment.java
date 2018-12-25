package ru.job4j.search.sortdepartment;

import java.util.*;

public class SortDepartment {
//    public String[] department(String[] depart){
//        List<String> list = new ArrayList<>();
//        for (String s : depart) {
//            for (int i = 0; i < s.length() ; i++) {
//                if (s.charAt(i) == '\\') {
//                    list.add(s.substring(0, i));
//                } else if (i == s.length() - 1){
//                    list.add(s.substring(0, i + 1));
//                }
//            }
//        }
//        return list.toArray(new String[list.size()]);
//    }

    public String[] sort(String[] depart) {
        List<String> list = new ArrayList<>();
        for (String s : depart){
            String[] dep = s.split("\\\\");
            for (String mas : dep) {
                list.add(mas);
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                int minim = Math.min(o1.length(), o2.length());
                if (o1.length() > o2.length()) {
                    result = 1;
                } else if (o1.length() < o2.length()) {
                    result = -1;
                } else if (o1.length() == o2.length()) {
                    for (int i = 0; i < minim ; i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            result = o1.compareTo(o2);
                            break;
                        }
                    }
                }
                return result;
            }
        });
//        Arrays.sort(depart);
//        return depart;
        return list.toArray(new String[list.size()]);
    }

    public String[] reverseSort(String[] depart) {
        List<String> list = new ArrayList<>();
        for (String s : depart){
            String[] dep = s.split("\\\\");
            for (String mas : dep) {
                list.add(mas);
            }
        }
        list.sort(new Comparator<String>() {
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
        return list.toArray(new String[list.size()]);
    }
}
