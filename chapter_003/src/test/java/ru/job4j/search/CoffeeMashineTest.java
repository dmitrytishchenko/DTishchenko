package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoffeeMashineTest {
    @Test
    public void whenValue50Price20() {
        CoffeeMashine coffeeMashine = new CoffeeMashine();
        int[] result = coffeeMashine.changes(50, 20);
        int[] expected = {10, 10, 10};
        assertThat(expected, is(result));
    }
    @Test
    public void whenValue50Price35() {
        CoffeeMashine coffeeMashine = new CoffeeMashine();
        int[] result = coffeeMashine.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(expected, is(result));
    }
    @Test
    public void whenValue100Price25() {
        CoffeeMashine coffeeMashine = new CoffeeMashine();
        int[] result = coffeeMashine.changes(100, 25);
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 5};
        assertThat(expected, is(result));
    }
}