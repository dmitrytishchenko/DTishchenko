package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean mark0 = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX) {
        this.markX = markX;
        this.mark0 = !markX;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.mark0 = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMark0() {
        return this.mark0;
    }

}
