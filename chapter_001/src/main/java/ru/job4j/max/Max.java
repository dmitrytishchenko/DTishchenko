package ru.job4j.max;

public class Max {
    public int max(int first, int second){
        return  first > second ? first : second;
    }
    public int max(int first, int second, int third){
        return Math.max(first, Math.max(second, third));
    }
}
