package ru.job4j.list;

public class SimpleStack<E> {
    SimpleLinkedList<E> list = new SimpleLinkedList<>();

    public E poll() {
        return list.removeLast();
    }
    public void push(E value) {
        list.add(value);
    }
    public int size() {
        return this.list.size;
    }
}
