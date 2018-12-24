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
        Arrays.sort(depart);
        return depart;
    }

    public String[] reverseSort(String[] depart) {
        List<String> list = new ArrayList<>();
        for (String s : depart) {
            list.add(s);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = o1.length();
                int b = o2.length();
                int result = 0;

//                int min = Math.min(a, b);
//                for (int i = 0; i < min; i++) {
//                    char c1 = o1.charAt(i);
//                    char c2 = o2.charAt(i);
//                    if (c1 != c2) {
//                        return c2 - c1;
//                    }
//                }
//                return a - b;
                String[] mas1 = o1.split("\\\\");
                String[] mas2 = o2.split("\\\\");
                int firstlength = mas1.length;
                int secondlength = mas2.length;
                int minimal = Math.min(firstlength, secondlength);
                for (int i = 0; i < minimal; i++) {
                    char[] c1 = mas1[i].toCharArray();
                    char[] c2 = mas2[i].toCharArray();
                    int charmin = Math.min(c1.length, c2.length);
                    for (int j = 0; j < charmin; j++) {
                        if (c1[j] != c2[j]) {
                            result = c2[j] - c1[j];
                            break;
                        }
                    }
                }
                if (result == 0) {
                    if (a > b) {
                        result = 1;
                    } else {
                        result = -1;
                    }
                }
                return result;
            }

        });
        return list.toArray(new String[list.size()]);
    }
}
