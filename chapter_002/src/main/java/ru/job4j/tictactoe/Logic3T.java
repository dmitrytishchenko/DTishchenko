package ru.job4j.tictactoe;

import ru.job4j.chess.firuges.Figure;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(Figure3T::hasMarkX, i, i, i + 1, i)
                    || this.fillBy(Figure3T::hasMarkX, i, i, i, i + 1)) {
                result = true;
            } else if (this.fillBy(Figure3T::hasMarkX, i, i, i + 1, i + 1)
                    || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, i, this.table.length - 2, i + 1))
                    result = true;
            break;
        } return result;
    }





//        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
//                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
//                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
//                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, 0, 1)
//                || this.fillBy(Figure3T::hasMarkX, this.table.length - 2, 0, 0, 1)
//                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 1, 1, 0)
//                || this.fillBy(Figure3T::hasMarkX, 0, this.table.length - 2, 1, 0)
//                || this.fillBy(Figure3T::hasMarkX, 0, 2, 1, -1);


    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMark0, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMark0, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMark0, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMark0, this.table.length - 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMark0, this.table.length - 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMark0, 0, this.table.length - 1, 1, 0)
                || this.fillBy(Figure3T::hasMark0, 0, this.table.length - 2, 1, 0)
                || this.fillBy(Figure3T::hasMark0, 0, 2, 1, -1);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMark0()) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }

        } return result;
    }
}



