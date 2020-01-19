package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Дмитрий Тищенко
 * @version $Id$
 * @since 17.02.2019
 */
public class DynamicArray<E> implements Iterable<E> {
    private int size = 3;
    private Object[] container = new Object[size];
    private int index = 0;
    private int modCount = 0;

    public DynamicArray() {
    }

    public DynamicArray(int newSize) {
        this.size = newSize;
    }

    public void add(E value) {
        if (this.index == this.size) {
            increase();
            this.container[this.index++] = value;
            modCount++;
        } else {
            this.container[this.index++] = value;
        }
    }

    public E get(int index) {
        return (E) container[index];
    }

    public void increase() {
        Object[] newContainer = new Object[this.size + 1];
        System.arraycopy(this.container, 0, newContainer, 0, container.length);
        this.size = newContainer.length;
        this.container = newContainer;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int carret = 0;

            @Override
            public boolean hasNext() {
                if (modCount > expectedModCount) {
                    throw new ConcurrentModificationException("Коллекция модифицирована");
                }
                return carret < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент коллекции отсутствует");
                }
                return (E) container[carret++];
            }
        };
    }
}