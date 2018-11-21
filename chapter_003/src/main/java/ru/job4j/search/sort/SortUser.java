package ru.job4j.search.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                Integer user1NameLength = user1.getName().length();
                Integer user2NameLength = user2.getName().length();
                return user1NameLength.compareTo(user2NameLength);
            }
        });
        return list;
    }

    public List<User> sortByAllFields (List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                Integer age1 = o1.getAge();
                Integer age2 = o2.getAge();
                return result != 0 ? result : age1.compareTo(age2);
            }
        });
        return list;
    }
}

