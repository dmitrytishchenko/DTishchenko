package ru.job4j.multithreading.bombermen;

public class Start {
    private final Board board = new Board(100, 100);
    private int x = 0;
    private int y = 0;
    public void start(int mosters, int sizeLockRegion) {
        Lockregion lockregion = new Lockregion(sizeLockRegion);
        Hero hero = new Hero(board, x, y);
        for (int i = 0; i < mosters; i++) {
            Monster monster1 = new Monster(board, x++, y++);
        }
    }
}
