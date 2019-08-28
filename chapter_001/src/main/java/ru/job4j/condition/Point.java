package ru.job4j.condition;
/**
 * Это четвертая моя программа
 * @version 1.04 3.12.2017
 * @author Dmitriy Tishchenko
 * @version 1.04 3.12.2017
 */
public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2) + Math.pow(that.z - this.z, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}


