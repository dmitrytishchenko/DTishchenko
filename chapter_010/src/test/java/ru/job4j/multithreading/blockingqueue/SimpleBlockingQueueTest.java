package ru.job4j.multithreading.blockingqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {
    @Test
    public void addThreeElements() throws InterruptedException {
        int size = 3;
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < size; i++) {
                    queue.offer(i);
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!queue.isEmptyQueue()) {
                    try {
                        queue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        producer.join();
        consumer.start();
        consumer.join();
        assertThat(queue.getSize(), is(0));
    }
}