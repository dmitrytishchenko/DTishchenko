package ru.job4j.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountingFunction {
    public List<Double> function(int start, int end, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i != end; i++) {
            list.add(function.apply(Double.valueOf(i)));
        }
        return list;
    }

}
