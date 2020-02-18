package ru.job4j.multithreading.elevator;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Elevator {
    private Scanner scanner = new Scanner(System.in);
    private int request = 0;

    public void start(String[] args) {
        Args args1 = new Args(args);
        System.out.println("Укажите где Вы находитесь : лифт или подъезд");
        if (scanner.next().equals("лифт")) {
            request = callFromElevator();
        } else {
            request = callFromTheEntrance();
        }
        CountDownLatch cd = new CountDownLatch(request);
        new ElevatorThread(cd, request, args1);
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
