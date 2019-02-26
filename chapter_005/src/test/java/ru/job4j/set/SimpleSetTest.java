package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<Integer> set;
    @Before
    public void before() {
        set = new SimpleSet<>(2);
        set.add(1);
        set.add(2);
        set.add(2);
    }
    @Test
    public void whenAddToSetFourValues() {
        assertThat(set.getSize(), is(2));
    }
    @Test
    public void whenHasNextIsTrueAndNextIsValue() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
    }
    @Test
    public void whenHasNextIsTrue() {
        Iterator<Integer> iter = set.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
    }
    @Test
    public void whenNextIsValue() {
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }
}