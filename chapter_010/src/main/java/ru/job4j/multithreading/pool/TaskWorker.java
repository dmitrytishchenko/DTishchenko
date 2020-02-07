package ru.job4j.multithreading.pool;

import ru.job4j.multithreading.blockingqueue.SimpleBlockingQueue;

public class TaskWorker implements Runnable {
    private SimpleBlockingQueue<Runnable> tasks;
    private Runnable task;

    public TaskWorker(SimpleBlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
        try {
            task = tasks.poll();
            task.run();
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }
}
