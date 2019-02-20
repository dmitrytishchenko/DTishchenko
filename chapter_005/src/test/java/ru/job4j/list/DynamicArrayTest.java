package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> list;
    @Before
    public void beforeTest() {
        list = new DynamicArray<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }
    @Test
    public void whenAddNewObject() {
        assertThat(list.get(0), is(1));
    }
    @Test
    public void whenAddThreeObjectsThenGetSizeResultThree() {
        assertThat(list.getSize(), is(6));
    }
    @Test
    public void whenUseIncreaseList() {
        assertThat(list.get(5), is(6));
    }
    @Test
    public void whenHasNextIsTrueAndNextIsValue() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
    }
    @Test
    public void whenHasNextIsTrue() {
        Iterator<Integer> iter = list.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
    }
    @Test
    public void whenNextIsValue() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
    }
}