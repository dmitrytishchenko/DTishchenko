package ru.job4j.multithreading.elevator;

import java.util.concurrent.CountDownLatch;

public class ElevatorThread implements Runnable {
    private Args args;
    private CountDownLatch cd;
    private int move = 0;
    private int request;
    private int level;

    public ElevatorThread(CountDownLatch cd, int request, Args args) {
        this.cd = cd;
        this.request = request;
        this.args = args;
        new Thread(this).start();
    }


    @Override
    public void run() {
        movement();
        for (int i = 0; i < this.move; i++) {
            cd.countDown();
            System.out.printf("Лифт проезжает - %s этаж ", i);
            System.out.println();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Лифт прибыл на " + this.level + " этаж");
        try {
            System.out.println("Двери лифта открыты");
            Thread.sleep(Integer.valueOf(this.args.getTimeOpenDoors()) * 1000);
            System.out.println("Двери лифта закрыты");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int movement() {
        if (this.move == 0) {
            this.move += this.request;
            this.level = this.move;
        } else if (this.level > this.request) {
            this.move = this.level - this.request;
            this.level = this.request;
        } else {
            this.move = this.request - this.level;
            level = request;
        }
        return this.move;
    }

    public int getLevel() {
        return level;
    }
}
