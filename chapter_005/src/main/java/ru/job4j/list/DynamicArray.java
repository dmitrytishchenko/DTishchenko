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
    private Object[] container;
    private int size;
    private int index = 0;
    private int modCount = 0;

    public DynamicArray(int size) {
        this.container = new Object[size];
        this.size = size;
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
        Object[] newContainer = new Object[this.size * 2];
        System.arraycopy(this.container, 0, newContainer, 0, this.index);
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
                if(modCount > expectedModCount) {
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
