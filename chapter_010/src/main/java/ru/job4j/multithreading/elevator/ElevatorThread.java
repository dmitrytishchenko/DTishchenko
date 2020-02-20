package ru.job4j.multithreading.elevator;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class ElevatorThread implements Runnable {
    private Args args;
    private CountDownLatch cd;
    private int move = 0;
    private int request;
    private int level = 1;
    private Scanner scanner = new Scanner(System.in);

    public ElevatorThread(CountDownLatch cd, int request, Args args) {
        this.cd = cd;
        this.request = request;
        this.args = args;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            call();
            if (this.level == 1) {
                movement();
                for (int i = 1; i < this.move; i++) {
                    cd.countDown();
                    movementElevator(i);
                }
            } else if (this.level < this.request) {
                movement();
                for (int i = this.level; i < this.request; i++) {
                    cd.countDown();
                    movementElevator(i);

                }
                this.level = this.request;
            } else {
                movement();
                for (int i = this.level; i > this.request; i--) {
                    cd.countDown();
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
        }
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

    public void call() {
        System.out.println("Укажите где Вы находитесь : лифт или подъезд");
        if (scanner.next().equals("лифт")) {
            request = callFromElevator();
        } else {
            request = callFromTheEntrance();
        }
    }

    public int callFromElevator() {
        System.out.println("Вызов команды из лифта. Укажите этаж.");
        return scanner.nextInt();
    }

    public int callFromTheEntrance() {
        System.out.println("Вызов команды из подъезда. Укажите этаж.");
        return scanner.nextInt();
    }
}
