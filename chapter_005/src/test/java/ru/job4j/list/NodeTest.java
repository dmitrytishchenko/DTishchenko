package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void whenListIsNotCycledThenGetFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;

        Node<Integer> list = new Node<>(1);
        boolean result = list.hasCycle(first);

        assertThat(result, is(false));
    }

    /**
     * Test list is cycled.
     */
    @Test
    public void whenListIsCycledThenGetTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        Node<Integer> list = new Node<>(1);
        boolean result = list.hasCycle(first);

        assertThat(result, is(true));
    }

    /**
     * Test list is cycled.
     */


}