package ru.job4j.testtask;

import java.util.Arrays;

public class Twoarray<E> {
    private E[] array1;
    private E[] array2;

    public Twoarray() {
        this.array1 = array1;
        this.array2 = array2;
    }
    public boolean compare(E[] array1, E[] array2) {
        boolean result = false;
        if (Arrays.equals(array1, array2)) {
            result = true;
        }
        return result;
    }
}
