package ru.job4j.search.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> result = list.stream().sorted((n1,n2) -> n1.getName().length() - n2.getName().length()).collect(Collectors.toList());
//        list.sort(new Comparator<User>() {
//            @Override
//            public int compare(User user1, User user2) {
//                return Integer.compare(user1.getName().length(), user2.getName().length());
//            }
//        });
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream()
                .sorted(Comparator.comparing(User :: getName).thenComparing(User :: getAge))
                .collect(Collectors.toList());

//        list.sort(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                final int result = o1.getName().compareTo(o2.getName());
//                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
//            }
//        });
//        return list;
    }

}

