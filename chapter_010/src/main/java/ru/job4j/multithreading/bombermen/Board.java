package ru.job4j.multithreading.bombermen;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private final ReentrantLock[][] board;
    private final int weight;
    private final int height;

    public Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.board = new ReentrantLock[weight][height];
        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < height; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }

    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        try {
            if (this.board[dist.getX()][dist.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                if (this.board[source.getX()][source.getY()].isLocked()) {
                    this.board[source.getX()][source.getY()].unlock();
                }
                this.board[dist.getX()][dist.getY()].lock();
                result = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
