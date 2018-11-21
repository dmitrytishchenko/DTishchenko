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
        list.add(new User("Petia", 12));
        list.add(new User("Vasia", 14));
        list.add(new User("Artem", 42));
        list.add(new User("Zenia", 34));
        Set<User> result = sortUser.sort(list);
        TreeSet<User> treeSet = new TreeSet<>(list);
        assertThat(treeSet, is(result));
    }
    @Test
    public void sortByNameLenght(){
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Aleksey", 22));
        list.add(new User("Bob", 12));
        list.add(new User("Lexa", 34));
        list.add(new User("Al", 4));
        List result = sortUser.sortNameLength(list);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Al", 4));
        expected.add(new User("Bob", 12));
        expected.add(new User("Lexa", 34));
        expected.add(new User("Aleksey", 22));
        assertThat(result, is(expected));
    }
    @Test
    public void sortByAllFields(){
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Aleksey", 22));
        list.add(new User("Bob", 12));
        list.add(new User("Lexa", 34));
        list.add(new User("Al", 4));
        List result = sortUser.sortByAllFields(list);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Al", 4));
        expected.add(new User("Aleksey", 22));
        expected.add(new User("Bob", 12));
        expected.add(new User("Lexa", 34));
        assertThat(result, is(expected));
    }
}