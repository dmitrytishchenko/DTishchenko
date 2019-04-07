package ru.job4j.testtask;

import java.util.*;

public class Twoarray {
    private List<Integer> ar1;
    private List<Integer> ar2;

    public Twoarray() {
        this.ar1 = ar1;
        this.ar2 = ar2;
    }

    public boolean compare(List<Integer> ar1, List<Integer> ar2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : ar1) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, i + 1);
            }
        }
        for (Integer j : ar2) {
            if (map.values().contains(1)) {
                map.remove(j);
            } else {
                map.remove(j, j + 1);
            }
        }
        return map.isEmpty();
    }
}
