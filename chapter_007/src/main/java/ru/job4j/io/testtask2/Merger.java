package ru.job4j.io.testtask2;

import java.util.*;
import java.util.stream.Collectors;

public class Merger {
    public Map<User, List<String>> start(Map<User, List<String>> map) {
        Map<String, User> map1 = new HashMap<>();
        for (User user : map.keySet()) {
            for (String email : map.get(user)) {
                map1.put(email, user);
            }
        }
        Map<User, List<String>> map2 = map1.keySet().stream()
                .distinct().collect(Collectors.groupingBy(map1::get, Collectors.toList()));
        return map2;
    }
}

