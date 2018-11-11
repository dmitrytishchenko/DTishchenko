package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        for (User value: list){
            users.put(value.getId(), value);
        }
        return users;
    }
}
