package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int value = first > second ? first : second;
        int result = value > third ? value : third;
        return result;
    }
}