package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> result;
            @Override
            public boolean hasNext() {
                while (result == null || !result.hasNext()) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    result = it.next();
                }
                return true;
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент массива отсутствует");
                }
                return result.next();
            }
        };
    }
}
