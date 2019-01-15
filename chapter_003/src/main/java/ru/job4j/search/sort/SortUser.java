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
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream()
                .sorted(Comparator.comparing(User :: getName).thenComparing(User :: getAge))
                .collect(Collectors.toList());
    }

}

