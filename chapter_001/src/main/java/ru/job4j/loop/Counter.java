package ru.job4j.loop;
/**
 * Это седьмая моя программа
 * @version 1.07 11.12.2017
 * @author Dmitriy Tishchenko
 */
public class Counter {
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
