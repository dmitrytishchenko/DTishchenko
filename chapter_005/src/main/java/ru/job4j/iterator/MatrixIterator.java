package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Необходимо создать итератор для двухмерного массива.
 *
 * int[][] value = {
 *    {1, 2}
 *    {3, 4}
 * };
 *
 * метод next = должен вернуть последовательно 1, 2, 3, 4.
 *
 * Старайтесь написать универсальное решение, чтобы оно не было жестко ориентировано на тестовый пример.
 * И хотя в примере указана квадратная матрица, программа должна корректно обрабатывать и jagged array тоже.
 * Пример jagged array - {{1},{2, 3, 4, 5,},{6, 7}, {8, 9, 10, 11, 12, 13, 14}}
 * Не используйте в данном задании коллекции из JDK, вспомогательные массивы и т.д.
 * Постарайтесь реализовать последовательным проходом по массиву.
 */

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
