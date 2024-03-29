package ru.job4j.tree;


import java.util.*;

public class Tree<T extends Comparable<T>> implements SimpleTree<T> {
    private Node<T> root;

    /**
     * Конструктор
     */
    public Tree(T root) {
        this.root = new Node<>(root);
    }

    /**
     * Добавить элемент child в parent
     * Parent может иметь список child
     *
     * @param parent parent
     * @param child  child
     * @return
     */
    @Override
    public boolean add(T parent, T child) {
        boolean result = false;
        Optional<Node<T>> par1 = findBy(parent);
        Optional<Node<T>> ch = findBy(child);
        if (par1.isPresent() && !ch.isPresent()) {
            par1.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    /**
     * метод для поиска по дереву
     */
    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(root);
        if (!data.isEmpty()) {
            Node<T> element = data.poll();
            for (Node<T> child : element.leaves()) {
                data.offer(child);
            }
            if (element.leaves().size() > 2) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Queue<Node<T>> data = new LinkedList<>();

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public T next() {
                Node<T> element;
                if (!hasNext()) {
                    throw new NoSuchElementException("No elements");
                } else {
                    element = data.remove();
                    for (Node<T> child : element.leaves()) {
                        data.offer(child);
                    }
                }
                return element.getValue();
            }
        };
    }
}
