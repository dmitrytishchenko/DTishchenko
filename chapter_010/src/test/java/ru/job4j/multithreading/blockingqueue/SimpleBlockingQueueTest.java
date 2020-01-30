package ru.job4j.multithreading.blockingqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

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
    @Test
    public void testForBlockingQueue1() {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(() -> {
            IntStream.range(0, 5).forEach(queue::offer);
        });
        producer.start();
        Thread consumer = new Thread(() -> {
            while (!queue.isEmptyQueue() || !Thread.currentThread().isInterrupted()) {
                try {
                    buffer.add(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        consumer.start();
        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.interrupt();
        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
    @Test
    public void testForBlockingQueue2() {
        final CopyOnWriteArrayList<Integer> buf = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    queue.offer(i);
                }
            }
        });
        producer.start();
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!queue.isEmptyQueue() || !Thread.currentThread().isInterrupted()) {
                    try {
                        buf.add(queue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        consumer.start();
        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.interrupt();
        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(buf, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}