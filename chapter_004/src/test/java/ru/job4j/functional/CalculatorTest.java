package ru.job4j.functional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calculator = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calculator.multiple(0, 3, 1, MathUtil::add, // static call
                buffer::add);  // non-static call
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}