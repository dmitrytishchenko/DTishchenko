package ru.job4j.testtask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoarrayTest {
    @Test
    public void whenCheckContainsEqualseTrue() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        assertThat(new Twoarray().compare(listOne, listTwo), is(true));
    }

    @Test
    public void whenCheckContainsEqualseTrue2() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertThat(new Twoarray().compare(listOne, listTwo), is(true));
    }

    @Test
    public void whenCheckContainsEqualseFalse() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 7));
        assertThat(new Twoarray().compare(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse2() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 1, 4, 3));
        assertThat(new Twoarray().compare(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse3() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertThat(new Twoarray().compare(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse4() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1, 5));
        assertThat(new Twoarray().compare(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse5() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 2, 2));
        assertThat(new Twoarray().compare(listOne, listTwo), is(false));
    }
}