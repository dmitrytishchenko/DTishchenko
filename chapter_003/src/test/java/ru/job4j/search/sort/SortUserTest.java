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
        List<User> list = List.of(
                new User("Petia", 12),
                new User("Vasia", 14),
                new User("Artem", 42),
                new User("Zenia", 34));
        Set<User> result = sortUser.sort(list);
        TreeSet<User> treeSet = new TreeSet<>(list);
        assertThat(treeSet, is(result));
    }
    @Test
    public void sortByNameLenght() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Aleksey", 22),
                new User("Bob", 12),
                new User("Lexa", 34),
                new User("Al", 4));
        List result = sortUser.sortNameLength(list);
        List<User> expected = List.of(
                new User("Al", 4),
                new User("Bob", 12),
                new User("Lexa", 34),
                new User("Aleksey", 22));
        assertThat(result, is(expected));
    }
    @Test
    public void sortByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Aleksey", 22),
                new User("Bob", 12),
                new User("Lexa", 34),
                new User("Al", 4));
        List result = sortUser.sortByAllFields(list);
        List<User> expected = List.of(
                new User("Al", 4),
                new User("Aleksey", 22),
                new User("Bob", 12),
                new User("Lexa", 34));
        assertThat(result, is(expected));
    }
}