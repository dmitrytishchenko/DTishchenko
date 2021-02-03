package ru.job4j.multithreading.pool;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ThreadPoolTest {
    @Test
    public void testThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool pool = new ThreadPool(size);
        AtomicInteger count = new AtomicInteger();
        pool.work(()-> count.getAndIncrement());
        pool.work(()-> count.getAndIncrement());
        pool.work(()-> count.getAndIncrement());
        pool.work(()-> count.getAndIncrement());
        pool.shutdown();
        assertEquals(count.get(), 4);
    }
}