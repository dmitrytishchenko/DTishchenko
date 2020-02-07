package ru.job4j.multithreading.pool;

import ru.job4j.multithreading.blockingqueue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public ThreadPool(int size) {
        addThreads(size);
        startThreads();
    }

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        threads.clear();
    }

    public void addThreads(int size) {
        for (int i = 0; i < size; i++) {
            this.threads.add(new Thread(new TaskWorker(tasks)));
        }
    }

    public void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

}
