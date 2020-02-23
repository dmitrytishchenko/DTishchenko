package ru.job4j.multithreading.bombermen;

import java.util.concurrent.locks.ReentrantLock;

public class Hero {
    private final ReentrantLock[][] board;
    private final int x;
    private final int y;

    public Hero(ReentrantLock[][] board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }
}
