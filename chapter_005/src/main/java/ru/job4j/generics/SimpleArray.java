package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    Object[] mas;
    private int position = 0;

    public SimpleArray(int size) {
        this.mas = new Object[size];
    }

    public void add(T model) {
        this.mas[position++] = model;
    }
    public void set(int index, T model) {
        if (index >= 0 && index < position) {
            this.mas[index] = model;
        } else {
            throw new IndexOutOfBoundsException("Индекс находится за пределами массива");
        }
    }
    public void remove(int index) {
        System.arraycopy(this.mas, index + 1, this.mas, index, this.mas.length - index - 1);
        this.position--;
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
                return this.index < position;
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
    public int getLenght() {
        return this.mas.length;
    }
}
