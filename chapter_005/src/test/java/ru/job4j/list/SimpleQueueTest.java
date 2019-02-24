package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue = new SimpleQueue<>();
    @Test
    public void whenPushAndPollToQueue() {
        assertNull(queue.poll());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
    @Test
    public void whenPushAndPollToQueue2() {
        assertNull(queue.poll());
        queue.push(1);
        queue.push(2);
        queue.poll();
        queue.push(3);
        queue.poll();
        assertThat(queue.poll(), is(2));
    }
}