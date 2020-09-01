package ru.job4j.multithreading.bombermen;

import java.util.Random;

public class Hero extends Thread {
    private final Board board;
    private int x;
    private int y;

    public Hero(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.board.move(getSource(), implementationOfUser());
            System.out.printf("Hero go to X - %s, Y - %s", implementationOfUser().getX(), implementationOfUser().getY());
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public Cell getSource() {
        return new Cell(this.x, this.y);
    }

    public Cell implementationOfUser() {
        return new Cell(new Random().nextInt(this.board.getSize()), new Random().nextInt(this.board.getSize()));
    }
}
