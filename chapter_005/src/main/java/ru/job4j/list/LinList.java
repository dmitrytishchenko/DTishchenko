package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public void add(E date) {
        Node<E> newNode = new Node<>(date);
        if (this.size > 0) {
            last.next = newNode;
            newNode.previus = last;
        } else {
            first = newNode;
        }
        last = newNode;
        this.size++;
        this.modCount++;
    }
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> caret = first;
            int expectModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount > expectModCount) {
                    throw new ConcurrentModificationException("Коллекция модифицирована");
                }
                return caret != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = caret.date;
                caret = caret.next;
                return result;
            }
        };
    }
    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> previus;

        public Node(E date) {
            this.date = date;
        }
    }
}
