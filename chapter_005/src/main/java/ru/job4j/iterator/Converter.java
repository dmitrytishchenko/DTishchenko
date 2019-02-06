package ru.job4j.iterator;

import java.util.Iterator;

public class Converter {
    private Iterator<Integer> result;
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
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
            public Integer next() {
                if (!hasNext()) {
                }
                return result.next();
            }
        };
    }
}
