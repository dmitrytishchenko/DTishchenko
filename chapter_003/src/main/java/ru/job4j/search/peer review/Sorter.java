package com;   // пакет должен быть уникальным


import java.util.*;

public class Sorter {

    public Sorter(){

    }

    Set<User> sort (List<User> list) {                   // нет полей класса, либо класса User
        TreeSet<User> sortedList = new TreeSet<>();       // Generic не указан
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();  // отсутствует класс User с геттерами
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}