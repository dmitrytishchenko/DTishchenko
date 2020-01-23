package ru.job4j.multithreading.blockingqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {
    @Test
    public void addThreeElements() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue(1);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.offer(1);
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.poll();
            }
        });
        producer.start();
        producer.join();
        consumer.start();
        consumer.join();
        assertThat(queue.getSize(), is(0));
    }
}