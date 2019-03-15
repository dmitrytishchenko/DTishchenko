package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
    private final List<Node<T>> children = new ArrayList<>();

    private final T value;

    public Node(final T value) {
        this.value = value;
    }

    public void add(Node<T> child) {
        this.children.add(child);
    }

    public List<Node<T>> leaves() {
        return this.children;
    }

    public boolean eqValue(T that) {
        return this.value.compareTo(that) == 0;
    }

    public T getValue() {
        return value;
    }
}
