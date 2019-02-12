package ru.job4j.iterator.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    Object[] mas;
    int index = 0;

    public SimpleArray(int size) {
        this.mas = new Object[size];
    }

    public void add(T model) {
        this.mas[index++] = model;
    }
    public void set(int index, T model) {
        this.mas[index] = model;
    }
    public void remove(int index) {
        System.arraycopy(this.mas, index + 1, this.mas, index, this.mas.length - index - 1);
        this.index--;
        this.mas[this.mas.length - 1] = null;
    }

    public T get(int index) {
        return (T) this.mas[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return SimpleArray.this.mas[this.index] == null || this.index < SimpleArray.this.mas.length - 1;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден.");
                }
                return (T) SimpleArray.this.mas[index++];
            }
        };
    }
}
