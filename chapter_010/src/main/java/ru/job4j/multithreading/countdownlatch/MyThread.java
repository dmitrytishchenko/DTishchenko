package ru.job4j.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    CountDownLatch countDownLatch;
    private final Object obj1;
    private final Object obj2;

    public MyThread(CountDownLatch countDownLatch, Object obj1, Object obj2) {
        this.countDownLatch = countDownLatch;
        this.obj1 = obj1;
        this.obj2 = obj2;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (obj1) {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("Thread end");
            }
        }
    }
}
