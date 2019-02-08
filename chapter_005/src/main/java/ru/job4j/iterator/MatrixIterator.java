package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {
    private int[][] array;
    private int str = 0;
    private int stlb = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    private void getNumber() {
        if (stlb < array[str].length - 1) {
            stlb++;
        } else {
            str++;
            stlb = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return str < array.length && stlb < array[str].length;
    }

    @Override
    public Integer next()throws NoSuchElementException {
        if (hasNext()) {
            Integer result = this.array[str][stlb];
            getNumber();
            return result;
        } else {
            throw new NoSuchElementException("Элемент массива отсутствует");
        }
    }
}
