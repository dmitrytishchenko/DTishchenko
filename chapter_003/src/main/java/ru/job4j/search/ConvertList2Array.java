package ru.job4j.search;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows){
        int cells = rows;
        if(cells * rows < list.size()) {
            cells++;
        }
        int [][] array = new int[rows][cells];
        int vert = 0;
        int goriz = 0;
        for (Integer value: list){
            array[vert][goriz] = value;
            goriz++;
            if(goriz >= cells){
                vert++;
                goriz = 0;
            }
        }
        return array;
    }
    public List<Integer> convert(List<int[]>list){
        for (int[] value: list){
            list.add(value);
        }
        ConvertList2Array convertList = new ConvertList2Array();
        List<Integer> result = convertList.convert(list);
        return result;
    }
}
