package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
//        создаем объект статистики
        Info info = new Info(0, 0, 0);
//        создаем карту с ключем id и значением name
        Map<Integer, String> map = new HashMap<>();
//        заносим в нашу карту ключ-значения user, через стрим
        previous.stream().forEach(user -> map.put(user.id, user.name));
//        находим количество добавленных user, путем сравнения исходного списка и измененного(все user, которых нет в исходном списке)
        info.added = (int) current.stream()
                .filter(user -> !previous.contains(user)).count();
//        находим количество измененных user, путем прохода по измененному списку и сравнения name при одинаковом id
        info.changed = (int) current.stream()
                .filter(user -> map.containsKey(user.id)
                        && !map.get(user.id).equals(user.name)).count();
//        находим количество удаленных user, путем сравнения исходного списка с измененным
        info.deleted = (int) previous.stream().filter(user -> !current.contains(user)).count();

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
