package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class InteractCalc implements Add, Subtract, Multiple, Div {
    private Map<Action.Type, BiFunction<Double, Double, Double>> dispatch = new HashMap<>();
    private Calculator calculator;
    boolean run = true;

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public BiFunction<Double, Double, Double> add() {
        return (first, second) -> {
            calculator.add(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    @Override
    public BiFunction<Double, Double, Double> subtract() {
        return (first, second) -> {
            calculator.subtract(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    @Override
    public BiFunction<Double, Double, Double> multiple() {
        return (first, second) -> {
            calculator.multiple(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    @Override
    public BiFunction<Double, Double, Double> div() {
        return (first, second) -> {
            calculator.div(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public void load(Action.Type action, BiFunction<Double, Double, Double> handle) {
        this.dispatch.put(action, handle);
    }

    public InteractCalc init() {
        this.load(Action.Type.add, this.add());
        this.load(Action.Type.subtract, this.subtract());
        this.load(Action.Type.multiple, this.multiple());
        this.load(Action.Type.div, this.div());
        return this;
    }

    public Double input() {
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        String action;
        double firstNumber;
        double secondNumber;
        System.out.println("Калькулятор готов к работе");
        while (run) {
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            showMenu();
            action = scanner.next();
            if (action.equals("Exit")) {
                System.out.println("Калькулятор завершил свою работу");
                break;
            } else if (action.equals("useLastResult")) {
                showMenu();
                scanner.nextDouble();
                firstNumber = calculator.getResult();
            } else {
                System.out.println("Введите первое значение");
                firstNumber = scanner.nextDouble();
            }
            System.out.println("Введите второе значение");
            secondNumber = scanner.nextDouble();
            this.init();
            for (Action.Type action1 : dispatch.keySet()) {
                if (action1.toString().equals(action)) {
                    result = this.dispatch.get(action1).apply(firstNumber, secondNumber);
                }
            }
        }
        return result;
    }

    public void showMenu() {
        System.out.println("Выберите дествие");
        System.out.println("add - сложение");
        System.out.println("subtract - вычитание");
        System.out.println("multiple - умножение");
        System.out.println("div - деление");
        System.out.println("useLastResult - использовать последний результат");
        System.out.println("Exit - выход");
    }

    public static void main(String[] args) {
        InteractCalc ic = new InteractCalc(new Calculator());
        ic.input();
    }
}
