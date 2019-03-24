package ru.job4j.statistics;

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
//        создаем объект статистики
        Info info = new Info(0, 0, 0);
//        создаем карту с ключем id и значением name
        Map<Integer, String> map = new HashMap<>();
        current.stream().forEach(user -> map.put(user.id, user.name));
        for (User user : previous) {
            if (map.containsKey(user.id) && !map.containsKey(user.name)) {
                info.changed++;
            } else if (!map.containsKey(user.id)) {
                info.deleted++;
            }
        }
        info.added = current.size();
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{" + "added=" + added + ", changed=" + changed + ", deleted=" + deleted + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added && changed == info.changed && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
