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
        /**
         * у хэшкода должен быть максимальный разбег в пределах int
         * использовать поля, которые используются в методе equals() (можно использовать меньше полей, чем в equals())
         * согласно документации переопределять hashcode вместе с equals()
         * если hashcode объектов равны, то не обязательно, что объекты равны и называется коллизией
         */
        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 * children;
            return result;
        }
        /**
         * После переопределения hashcode() объекты при выводе на печать выводятся согласно их хэшкодам,
         * т.е. после переопределения карта отсортирована на основе хэшкода
         */
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
