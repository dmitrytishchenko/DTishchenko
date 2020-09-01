package ru.job4j.multithreading.elevator;

public class Main {
    public static void main(String[] args) {
        Args args1 = new Args(args);
        ElevatorThread el1 = new ElevatorThread(args1, 5);
        ElevatorThread el2 = new ElevatorThread(args1, 7);
        el1.start();
        try {
            el1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        el2.start();
        try {
            el2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
