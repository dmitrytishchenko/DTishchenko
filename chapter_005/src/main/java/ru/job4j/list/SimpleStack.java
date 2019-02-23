package ru.job4j.list;

public class SimpleStack<E> {
    SimpleLinkedList<E> list = new SimpleLinkedList<>();
    private E stackDelLast;
    private E stackDelFirst;


    public E poll() {
        return list.removeLast();
    }
    public void push(E value) {
        list.add(value);
    }

    public E getstackDelLast() {
        return list.removeLast();
    }

    public E getstackDelFirst() {
        return list.removeFirst();
    }
}
