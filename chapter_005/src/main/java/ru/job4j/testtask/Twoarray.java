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
                map.put(i, map.get(i) + 1);
            }
        }
        if (ar1.size() == ar2.size()) {
            for (Integer j : ar2) {
                if (map.get(j) != null && map.get(j) > 1) {
                    map.put(j, map.get(j) - 1);
                } else {
                    map.remove(j);
                }
            }
        }
        return map.isEmpty();
    }
}
