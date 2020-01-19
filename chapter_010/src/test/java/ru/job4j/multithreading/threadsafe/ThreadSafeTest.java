package ru.job4j.multithreading.threadsafe;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThreadSafeTest {
    @Test
    public void whenUseIteratorByTwoThreads() {
        IThreadSafe<Integer> container = new ThreadSafe<Integer>();
        container.add(1);
        container.add(2);
        container.add(3);
        Iterator<Integer> itr1 = container.iterator();
        container.add(6);
        container.add(9);
        int result1 = 0;
        while (itr1.hasNext()) {
            itr1.next();
            result1++;
        }
        Iterator<Integer> itr2 = container.iterator();
        int result2 = 0;
        while (itr2.hasNext()) {
            itr2.next();
            result2++;
        }
        assertThat(result1, is(3));
        assertThat(result2, is(5));
    }
}