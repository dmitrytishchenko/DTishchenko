package ru.job4j.list;

public class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        Node one = first;
        Node two = first;
        while (one != null && two != null) {
            two = two.next;
            one = one.next.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}
