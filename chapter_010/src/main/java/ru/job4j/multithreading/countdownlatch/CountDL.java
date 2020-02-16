package ru.job4j.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDL {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new MyThread(countDownLatch, obj1, obj2);
        new MyThread(countDownLatch, obj1, obj2);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
