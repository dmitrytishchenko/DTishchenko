package ru.job4j.array;

public class Turn {
    public int[] back(int[] array){
        for (int i =0 ; i<array.length/2; i++){
            int x = 0;
            x = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = x;
        }
        return array;
    }
}

























   /* public int[] calculate(int bound){
        int[] rst = new int[bound];
        for(int i = 1; i<= bound; i++){
            rst[i-1] = i*i;
        }
        return rst;
        */