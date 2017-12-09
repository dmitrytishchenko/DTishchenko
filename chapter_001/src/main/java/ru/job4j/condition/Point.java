package ru.job4j.condition;

/**
 * Это четвертая моя программа
 * @version 1.04 3.12.2017
 * @author Dmitriy Tishchenko
 */
public class Point {
    protected int x;
    protected int y;

    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point that) {
         return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
            }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        //сделаем вывод метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между двуми точками А и В : " + result);
    }

}


