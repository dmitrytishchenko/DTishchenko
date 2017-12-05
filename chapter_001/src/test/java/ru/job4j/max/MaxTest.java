package ru.job4j.max;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(int first, int second);
        assertThat(result, is(int second));
    }
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(int first, int second);
        assertThat(result, is(int first));

}
