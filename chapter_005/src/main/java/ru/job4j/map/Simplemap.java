package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Simplemap {
    public static class User {
        private String name;
        private int children;
        private Calendar birthday;

        public User(String name) {
            this.name = name;
        }
    }
    public void map() {
        User user1 = new User("Dima");
        User user2 = new User("Dima");
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(map);
    }
}
