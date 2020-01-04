package ru.job4j.multithreading;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }
    @Override
    public void run() {
        int delta = 1;
        while (true) {
            if (this.rect.getX() == 0) {
                delta = 1;
            } else if (this.rect.getX() == 300) {
                delta = -1;
            }
            this.rect.setX(this.rect.getX() + delta);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}