package ru.job4j.multithreading.blockingqueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;


@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    @GuardedBy("this")
    private int sizeLimit = 3;

    public synchronized void offer(T value) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(value);
        notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (isEmptyQueue()) {
            wait();
        }
        T value = this.queue.poll();
        notifyAll();
        return value;
    }

    public synchronized boolean isEmptyQueue() {
        return this.queue.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.sizeLimit == queue.size();
    }

    public synchronized int getSize() {
        return this.queue.size();
    }
}
