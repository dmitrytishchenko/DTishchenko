package ru.job4j.multithreading;

/**
 * В данном классе показаны 3 потока, которые выполняют последовательные действия,
 * но в какой момент какой именно поток будет выполнен нельзя предугадать,
 * мы получаем разные результаты при запуске этого кода,
 * т.к. данные переменных могут быть прочитаны и держаться в кэше и запись производится по старым значениям.
 */
public class Jmm {
    private static int x = 0;
    private static int y = 0;
    private static int z = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            x = 1;
            System.out.println(String.format("x - %s, y - %s, z - %s", x, y, z));
        }).start();
        new Thread(() -> {
            while (x != 1) {
                y = 1;
            }
            System.out.println(String.format("x - %s, y - %s, z - %s", x, y, z));
        }).start();
        new Thread(() -> {
            while (y != 1) {
                z = x;
            }
            System.out.println(String.format("x - %s, y - %s, z - %s", x, y, z));
        }).start();
    }
}

