package ru.job4j.functional;

import java.util.Arrays;

public class MassivStream {
    public static int sumStream(int[] mas) {
        int result = Arrays.stream(mas)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .sum();
        return result;
    }
}
