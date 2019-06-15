package ru.job4j.condition;

public class SqArea {
    public static int square(int p, int k) {
        int h = p * k / (2 + 2 * k);
        return h * (h / k);
    }
}