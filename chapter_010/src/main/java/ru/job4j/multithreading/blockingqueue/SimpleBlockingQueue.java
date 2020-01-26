package ru.job4j.multithreading.blockingqueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final Object lock = new Object();
    private int size;

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }
    public SimpleBlockingQueue() {
    }

    public void offer(T value) {
        synchronized (this.lock) {
            if (this.size >= this.queue.size()) {
                this.queue.add(value);
                this.lock.notify();
            }
        }
    }

    public T poll() {
        synchronized (this.lock) {
            while (this.queue.isEmpty()) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.queue.poll();
    }

    public int getSize() {
        return this.queue.size();
    }

    public boolean isEmptyQueue() {
       return this.queue.isEmpty();
    }
}
