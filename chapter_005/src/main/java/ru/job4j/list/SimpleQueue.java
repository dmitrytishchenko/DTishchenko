package ru.job4j.list;

public class SimpleQueue<E> {
    private SimpleStack<E> first = new SimpleStack<>();
    private SimpleStack<E> last = new SimpleStack<>();

    public E poll() {
        move(first, last, first.size());
        return last.poll();
    }
    public void push(E value) {
        first.push(value);
    }
    public void move(SimpleStack<E> from, SimpleStack<E> to, int size) {
        for (int i = 0; i < size; i++) {
            to.push(from.poll());
        }
    }
}
