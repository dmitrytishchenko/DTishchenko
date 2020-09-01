package ru.job4j.multithreading.bombermen;

import java.util.Random;

public class Monster implements Runnable {
    private final Board board;
    private int x;
    private int y;

    public Monster(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.board.move(getSource(), getDist());
            System.out.printf("Monster go to X - %s, Y - %s", getDist().getX(), getDist().getY());
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public Cell getSource() {
        return new Cell(this.x, this.y);
    }

    public Cell getDist() {
        return new Cell(new Random().nextInt(board.getSize()), new Random().nextInt(board.getSize()));
    }
}
