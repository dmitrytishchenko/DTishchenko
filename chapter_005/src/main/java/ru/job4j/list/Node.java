package ru.job4j.list;

public class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public boolean hasCycle(Node first) {
        Node one = first;
        Node two = first;
        if (one != null && two != null) {
            two = two.next;
            one = one.next.next;
            if (two == one) {
                return true;
            }
        }
        return false;
    }
}
