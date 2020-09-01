package ru.job4j.multithreading.bombermen;

import java.util.concurrent.locks.ReentrantLock;

public class Lockregion {
    private final ReentrantLock[][] board;
    private final int size;

    public Lockregion(int size) {
        this.size = size;
        this.board = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
        lockReg();
    }
    public void lockReg() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j].lock();
            }
        }
    }

}
