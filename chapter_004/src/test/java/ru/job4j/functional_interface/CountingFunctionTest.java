package ru.job4j.functional_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class CountingFunctionTest {
    @Test
    public void whenLineFunctionThenLineResult() {
        CountingFunction countingFunction = new CountingFunction();
        List<Double> list = new ArrayList<>();
        int k = 3;
        int b = 4;
        list.addAll(countingFunction.function(1, 10, x -> k * x + b));
        assertThat(list, is(Arrays.asList(7D, 10D, 13D, 16D, 19D, 22D, 25D, 28D, 31D)));
    }
    @Test
    public void whenQuardaticFunctionThenQuardaticResult() {
        CountingFunction countingFunction = new CountingFunction();
        List<Double> list = new ArrayList<>();
        int a = 1;
        int b = 2;
        int c = 3;
        list.addAll(countingFunction.function(1, 10, x -> a * x * x + b * x + c));
        assertThat(list, is(Arrays.asList(6D, 11D, 18D, 27D, 38D, 51D, 66D, 83D, 102D)));
    }
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResult() {
        CountingFunction countingFunction = new CountingFunction();
        List<Double> list = new ArrayList<>();
        list.addAll(countingFunction.function(1, 10, x -> Math.log(x)));
        assertThat(list, is(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098, 1.3862943611198906, 1.6094379124341003, 1.791759469228055, 1.9459101490553132, 2.0794415416798357, 2.1972245773362196)));
    }
}