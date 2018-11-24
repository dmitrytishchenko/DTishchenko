package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = rows;
        if (cells * rows < list.size()) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int vert = 0;
        int goriz = 0;
        for (Integer value: list) {
            array[vert][goriz] = value;
            goriz++;
            if (goriz >= cells) {
                vert++;
                goriz = 0;
            }
        }
        return array;
    }
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] value: list) {
            for (int value1 : value) {
                result.add(value1);
            }
        }
        return result;
    }
}
