package ru.job4j.search;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] value: array) {
            for (int j: value) {
                list.add(j);
            }
        }
        return list;
    }
}
