package ru.job4j.testtask;

import java.util.*;
import java.util.stream.Collectors;

public class Twoarray {
    private List<Integer> ar1;
    private List<Integer> ar2;

    public Twoarray() {
        this.ar1 = ar1;
        this.ar2 = ar2;
    }

    public boolean compare(List<Integer> ar1, List<Integer> ar2) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (Integer i : ar1) {
            map.put(i, index);
            index++;
        }
        for (Integer i : ar2) {
            map.remove(i);
        }
        return map.isEmpty();
    }
}
