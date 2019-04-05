package ru.job4j.testtask;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoarrayTest {
    @Test
    public void whenTwoArrayIsEqually() {
        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();
        ar1.add(1);
        ar1.add(2);
        ar1.add(3);
        ar1.add(4);
        ar2.add(4);
        ar2.add(3);
        ar2.add(2);
        ar2.add(1);
        Twoarray twoarray = new Twoarray();
        boolean result = twoarray.compare(ar1, ar2);
        assertThat(result, is(true));
    }
    @Test

    public void whenTwoArrayIsNotEqually() {
        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();
        ar1.add(1);
        ar1.add(2);
        ar1.add(3);
        ar1.add(4);
        ar2.add(4);
        ar2.add(3);
        ar2.add(2);
        ar2.add(5);
        Twoarray twoarray = new Twoarray();
        boolean result = twoarray.compare(ar1, ar2);
        assertThat(result, is(false));
    }
}