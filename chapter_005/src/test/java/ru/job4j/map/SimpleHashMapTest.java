package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> map;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
//        map.insert(4, "four");
        map.insert(5, "five");
    }

    @Test
    public void whenInsertNewMap() {
        assertThat(map.size(), is(4));
    }

    @Test
    public void whenAddToMapAndGetByKey() {
        assertThat(map.get(3), is("three"));
    }

    @Test
    public void whenAddToMapAndDeleteByKey() {
        map.delete(1);
        assertThat(map.size(), is(3));

    }

    @Test
    public void whenHasNextIsTrueNextIsValue() {
        Iterator<Integer> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenHasNextIsTrue() {
        Iterator<Integer> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenNextIsValue() {
        Iterator<Integer> it = map.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
    }
}