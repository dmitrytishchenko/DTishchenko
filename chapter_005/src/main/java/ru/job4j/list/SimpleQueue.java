package ru.job4j.list;

public class SimpleQueue<E> {
    SimpleStack<E> stack;

    public SimpleQueue() {
        this.stack = new SimpleStack<>();
    }

    public E poll() {
        return stack.getstackDelFirst();
    }
    public void push(E value) {
        stack.push(value);
    }
}
