package ru.job4j.odd;

import ru.job4j.calculator.Calculator;

import java.util.Scanner;

public class InteractCalc {
    private Calculator calculator;
    boolean run = true;

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    public double input() {
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        double first;
        double second;
        System.out.println("Калькулятор готов к работе");
        while (run) {
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            showMenu();
            int action = scanner.nextInt();
            if (action == 6) {
                System.out.println("Калькулятор завершил свою работу");
                break;
            } else if (action == 5) {
                showMenu();
                action = scanner.nextInt();
                first = calculator.getResult();
            } else {
                System.out.println("Введите первое значение");
                first = scanner.nextDouble();
            }
            System.out.println("Введите второе значение");
            second = scanner.nextDouble();
            if (action == 1) {
                calculator.add(first, second);
                System.out.println(String.format("Результат равен - %f", calculator.getResult()));
            } else if (action == 2) {
                calculator.subtract(first, second);
                System.out.println(String.format("Результат равен - %f", calculator.getResult()));
            } else if (action == 3) {
                calculator.multiple(first, second);
                System.out.println(String.format("Результат равен - %f", calculator.getResult()));
            } else if (action == 4) {
                calculator.div(first, second);
                System.out.println(String.format("Результат равен - %f", calculator.getResult()));
            } else {
                System.out.println("Таких действий нет");
            }
        }
        return result;
    }

    public void showMenu() {
        System.out.println("Выберите дествие");
        System.out.println("1 - сложение");
        System.out.println("2 - вычитание");
        System.out.println("3 - умножение");
        System.out.println("4 - деление");
        System.out.println("5 - использовать полседний результат");
        System.out.println("6 - выход");
    }

    public static void main(String[] args) {
        InteractCalc ic = new InteractCalc(new Calculator());
        ic.input();
    }
}
