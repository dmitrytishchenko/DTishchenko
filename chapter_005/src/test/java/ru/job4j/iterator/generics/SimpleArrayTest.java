package ru.job4j.iterator.generics;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenModelAddToArray() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        int[] mas = new int[]{1};
        simpleArray.add(1);
        assertThat(mas.length, is(1));
    }
    @Test
    public void whenModelSetToArrayIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(1, 5);
        assertThat(simpleArray.mas[1], is(5));
    }
    @Test
    public void whenGetByArrayIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        int result = simpleArray.get(1);
        assertThat(result, is(2));
    }
    @Test
    public void whenRemoveElementByIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.remove(1);
        int result = simpleArray.get(0);
        assertThat(result, is(1));
    }
}