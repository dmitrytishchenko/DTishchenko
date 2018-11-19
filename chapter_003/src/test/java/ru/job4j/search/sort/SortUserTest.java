package ru.job4j.search.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void sort() throws Exception {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Petia", "19"));
        list.add(new User("Vasia", "20"));
        list.add(new User("Artem", "44"));
        list.add(new User("Zenia", "24"));
        Set<User> result = sortUser.sort(list);
        TreeSet<User> treeSet = new TreeSet<>(list);
        assertThat(treeSet, is(result));
    }
}