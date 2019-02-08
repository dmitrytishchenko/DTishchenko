package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (numbers.length == 0) {
            return false;
        }
        for (; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("Элемент массива отсутствует");
        }
        return numbers[index++];
    }
}

