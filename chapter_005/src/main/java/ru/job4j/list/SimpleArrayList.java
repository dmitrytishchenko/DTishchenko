package ru.job4j.list;

/**
 * @author Дмитрий Тищенко
 * @version $Id$
 * @since 17.02.2019
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;
    /**
     * Метод добавления нового объекта.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * Метод, который удаляет 1-й элемент в списке.
     */
    public E delete() {
        E result = null;
        Node<E> rst = this.first;
        for (int i = 0; i < size - 1; i++) {
            rst = rst.next;
            if (rst.next == null) {
                result = rst.date;
                rst = null;
                break;
            }
            size--;
        }
        return result;
    }
    /**
     * Метод получения объекта по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    /**
     * Метод получения общего размера.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Класс для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }
    }
}
