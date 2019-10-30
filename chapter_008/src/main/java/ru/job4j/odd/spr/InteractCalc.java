package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class InteractCalc {
    private Map<Integer, BiFunction<Double, Double, Double>> dispatch = new HashMap<>();
    private Calculator calculator;
    boolean run = true;

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    public BiFunction<Double, Double, Double> add() {
        return (first, second) -> {
            calculator.add(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public BiFunction<Double, Double, Double> subtract() {
        return (first, second) -> {
            calculator.subtract(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public BiFunction<Double, Double, Double> multiple() {
        return (first, second) -> {
            calculator.multiple(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public BiFunction<Double, Double, Double> div() {
        return (first, second) -> {
            calculator.div(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public void load(Integer number, BiFunction<Double, Double, Double> handle) {
        this.dispatch.put(number, handle);
    }

    public InteractCalc init() {
        this.load(1, this.add());
        this.load(2, this.subtract());
        this.load(3, this.multiple());
        this.load(4, this.div());
        return this;
    }

    public Double input() {
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        int action;
        double first;
        double second;
        System.out.println("Калькулятор готов к работе");
        while (run) {
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            showMenu();
            action = scanner.nextInt();
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
            this.init();
            result = this.dispatch.get(action).apply(first, second);
        }
        return result;
    }

    public void showMenu() {
        System.out.println("Выберите дествие");
        System.out.println("1 - сложение");
        System.out.println("2 - вычитание");
        System.out.println("3 - умножение");
        System.out.println("4 - деление");
        System.out.println("5 - использовать последний результат");
        System.out.println("6 - выход");
    }

    public static void main(String[] args) {
        InteractCalc ic = new InteractCalc(new Calculator());
        ic.input();
    }
}
