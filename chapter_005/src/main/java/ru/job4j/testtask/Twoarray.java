package ru.job4j.testtask;

import java.util.*;

/**
 * задача была задана на сдаче зачета - как сравнить 2 массива, после условия
 * были изменены на сравнение двух коллекций, причем необходимо было использовать HashMap
 * суть метода compare сводиться к тому, что данные 1- го списка мы записываем в HashMap в ключ,
 * а в значение мы записываем количество одинаковых значений.
 * Соответственно для проверки на равенство коллекций, необходимо удалить из HashMap элементы второго списка
 * и проверить мапу на наличие элементов.
 */
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
