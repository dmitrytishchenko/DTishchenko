package ru.job4j.multithreading.elevator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ElevatorThread extends Thread {
    private Args args;
    private int move = 0;
    private int request;
    private int level = 1;
    private Lock lock = new ReentrantLock();

    public ElevatorThread(Args args, int request) {
        this.args = args;
        this.request = request;
    }

    @Override
    public void run() {
        lock.lock();
        workElevator();
    }

    public void workElevator() {
        lock.lock();
        if (this.level == 1) {
            movement();
            for (int i = 1; i < this.move; i++) {
                movementElevator(i);
            }
        } else if (this.level < this.request) {
            movement();
            for (int i = this.level; i < this.request; i++) {
                movementElevator(i);
            }
            this.level = this.request;
        } else {
            movement();
            for (int i = this.level; i > this.request; i--) {
                movementElevator(i);
            }
            this.level = this.request;
        }
        System.out.println("Лифт прибыл на " + this.level + " этаж");
        try {
            System.out.println("Двери лифта открыты");
            Thread.sleep(Integer.valueOf(this.args.getTimeOpenDoors()) * 1000);
            System.out.println("Двери лифта закрыты");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void movementElevator(int value) {
        System.out.printf("Лифт проезжает - %s этаж ", value);
        System.out.println();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int movement() {
        if (this.move == 0) {
            this.move += this.request;
            this.level = this.request;
        } else if (this.level > this.request) {
            this.move = this.level - this.request;
        } else {
            this.move = this.request - this.level;
        }
        return this.move;
    }
}
