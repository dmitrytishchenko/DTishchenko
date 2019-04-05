package ru.job4j.testtask;

import java.util.Collections;
import java.util.List;

public class Twoarray {
    private List<Integer> ar1;
    private List<Integer> ar2;

    public Twoarray() {
        this.ar1 = ar1;
        this.ar2 = ar2;
    }

    public boolean compare(List<Integer> ar1, List<Integer> ar2) {
        boolean result = false;
        Collections.sort(ar1);
        Collections.sort(ar2);
        if (ar1.equals(ar2)) {
            result = true;
        }
        return result;
    }
}
