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
         * При переопределении только метода equals(), нет подтверждения, что объекты равны, поэтому будет на печать выведено 2 объекта
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return name.equals(user.name);
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
         * При переопределении методов equals() и hashCode() мы добавляем user1 в мапу, далее user2
         * и т.к. объекты одинаковы, то user2 перезатирает user1 и в выводе на печать получаем user2
         */

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
