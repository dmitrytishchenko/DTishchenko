package ru.job4j.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    public List<List<Integer>> convert(Integer[][] mas) {
        return List.of((Arrays.stream(mas)).flatMap(n -> Arrays.stream(n)).collect(Collectors.toList()));
    }
}
