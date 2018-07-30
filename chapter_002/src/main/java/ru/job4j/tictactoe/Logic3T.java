package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        if (this.table[0][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[2][2].hasMarkX()) {
            result = true;
        } else if (this.table[2][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[0][2].hasMarkX()) {
            result = true;
        }
        for (int i = 0; i < 2; i++) {
            if (this.table[i][0].hasMarkX() && this.table[i][1].hasMarkX() && this.table[i][2].hasMarkX()) {
                result = true;
            } else if (this.table[0][i].hasMarkX() && this.table[1][i].hasMarkX() && this.table[2][i].hasMarkX()) {
                result = true;
            }
        }
        return result;
    }
//    Данное решение было объяснено в задаче
//        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
//                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
//                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
//                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);

//    Данный код был дан в классе на git.
//        boolean result = true;
//        for (int row = 0; row < this.table.length; row++) {
//            result = true;
//            for (int cell = 0; cell < this.table.length - 1; cell++) {
//                if (!(this.table[row][cell].hasMarkX() && this.table[row][cell + 1].hasMarkX())) {
//                    result = false;
//                    break;
//                }
//            }
//            if (result) {
//                break;
//            }
//        }
//        return result;


    public boolean isWinnerO() {
        boolean result = false;
        if (this.table[0][0].hasMark0() && this.table[1][1].hasMark0() && this.table[2][2].hasMark0()) {
            result = true;
        } else if (this.table[2][0].hasMark0() && this.table[1][1].hasMark0() && this.table[0][2].hasMark0()) {
            result = true;
        }
        for (int i = 0; i < 2; i++) {
            if (this.table[i][0].hasMark0() && this.table[i][1].hasMark0() && this.table[i][2].hasMark0()) {
                result = true;
            } else if (this.table[0][i].hasMark0() && this.table[1][i].hasMark0() && this.table[2][i].hasMark0()) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMark0()) {
                    result = true;
                }

            }

        }
        return result;

    }

//    Данное решение было объяснено в задаче.
//    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
//        boolean result = true;
//        for (int index = 0; index != this.table.length; index++) {
//            Figure3T cell = this.table[startX][startY];
//            startX += deltaX;
//            startY += deltaY;
//            if (!predicate.test(cell)) {
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }
}
