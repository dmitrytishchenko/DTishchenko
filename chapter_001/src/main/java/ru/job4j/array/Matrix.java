package ru.job4j.array;
public class Matrix {
    int[][] multiple(int size) {
        int[][]rst = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rst[i][j]  = (i + 1) * (j + 1);
            }
        }
        return rst;
    }
}
