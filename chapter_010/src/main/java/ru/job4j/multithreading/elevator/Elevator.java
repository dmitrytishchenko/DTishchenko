package ru.job4j.multithreading.elevator;

import java.util.concurrent.CountDownLatch;

public class Elevator {

    private int request = 0;

    public void start(String[] args) {
        Args args1 = new Args(args);
        CountDownLatch cd = new CountDownLatch(request);
        new ElevatorThread(cd, request, args1);
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
