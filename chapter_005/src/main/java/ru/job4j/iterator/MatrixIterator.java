package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class MatrixIterator implements Iterator {
    int[][] array;
    int count = 0;
    int caret = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
        convert();
    }
    public int convert() {
        int[] result = Arrays.stream(this.array).flatMapToInt(n -> Arrays.stream(n)).toArray();
        count = result.length;
        return count;
    }
    public int getNumber() {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                if (index == caret) {
                    return this.array[i][j];
                } else {
                    index++;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean hasNext() {
        return caret < count;
    }

    @Override
    public Integer next() {
        Integer result = null;
        if (hasNext()) {
            result = getNumber();
            caret++;
        }
        return result;
    }
}
