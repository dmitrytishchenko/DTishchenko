package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoarrayTest {
    @Test
    public void whenTwoArrayIsEqually() {
        Integer[] array1 = new Integer[] {1, 2, 3, 4};
        Integer[] array2 = new Integer[] {1, 2, 3, 4};
        Twoarray twoarray = new Twoarray();
        boolean result = twoarray.compare(array1, array2);
        assertThat(result, is(true));
    }
    @Test
    public void whenTwoArrayIsNotEqually() {
        Integer[] array1 = new Integer[] {1, 2, 3, 4};
        Integer[] array2 = new Integer[] {1, 2, 3};
        Twoarray twoarray = new Twoarray();
        boolean result = twoarray.compare(array1, array2);
        assertThat(result, is(false));
    }
}