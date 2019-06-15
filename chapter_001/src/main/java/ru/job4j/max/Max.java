package ru.job4j.max;
public class Max {
    public int max(int first, int second) {
        return  first > second ? first : second;
    }
    public int max1(int first, int second, int third) {
        return max(first, max(second, third));
    }
    public int max2(int first, int second, int third, int four) {
        return max(first, max(second, max(third, four)));
    }
}
