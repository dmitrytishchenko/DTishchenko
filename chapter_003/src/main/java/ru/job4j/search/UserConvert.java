package ru.job4j.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> users = list.stream().collect(Collectors.toMap(User :: getId, n -> n));
        return users;
    }
}
