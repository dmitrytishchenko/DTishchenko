package ru.job4j.max;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }
    @Test
    public void whenSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(2, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenFirstLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenThreeNumber() {
        Max max = new Max();
        int result = max.max(1, 20, 30);
        assertThat(result, is(30));
    }
    @Test
    public void whenFourNumber() {
        Max max = new Max();
        int result = max.max(1, 20, 30, 40);
        assertThat(result, is(40));
    }
}
