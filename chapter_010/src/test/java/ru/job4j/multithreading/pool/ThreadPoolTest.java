package ru.job4j.multithreading.pool;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThreadPoolTest {
    @Test
    public void testThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool pool = new ThreadPool(size);
        int[] index = {0};
        pool.work(() -> index[0]++);
        pool.work(() -> index[0]++);
        pool.work(() -> index[0]++);
        pool.work(() -> index[0]++);
        pool.shutdown();
        assertThat(index[0], is(4));
    }
}