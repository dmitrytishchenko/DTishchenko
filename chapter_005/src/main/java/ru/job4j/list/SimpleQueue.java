package ru.job4j.list;

public class SimpleQueue<E> {
    SimpleStack<E> stack = new SimpleStack<>();
    public E poll() {
        return stack.list.removeFirst();
    }
    public void push(E value) {
        stack.push(value);
    }
}
