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
        first.next = two;
        two.next = third;
        third.next = four;
        boolean result = Node.hasCycle(first);
        assertThat(result, is(false));
    }
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
        boolean result = Node.hasCycle(first);
        assertThat(result, is(true));
    }
    @Test
    public void whenListIsNotCycledThenGetFalse2() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        boolean result = Node.hasCycle(first);
        assertThat(result, is(false));
    }
}