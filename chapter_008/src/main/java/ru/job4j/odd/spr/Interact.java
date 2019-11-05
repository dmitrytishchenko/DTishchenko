package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * Implementation of the Calculator from the console.
 */
public class Interact {
    /**
     * Object Calculator.
     */
    private Calculator calculator;
    /**
     * The run variable for the loop.
     */
    private boolean run = true;
    /**
     * Map dispatch, with key - String and value - BiFunction.
     */
    private Map<String, BiFunction<Double, Double, Double>> dispatch = new HashMap<>();

    /**
     * @param calculator
     */
    public Interact(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * @return double result operation of the calculator.
     */
    public Double input() {
        double result = 0;
        StandardCalculator sc = new StandardCalculator(this.dispatch);
        sc.init();
        Scanner scanner = new Scanner(System.in);
        String action;
        double firstNumber;
        double secondNumber;
        System.out.println("Калькулятор готов к работе");
        while (run) {
            showMenu();
            action = scanner.next();
            if (action.equals("Exit")) {
                System.out.println("Калькулятор завершил свою работу");
                break;
            } else if (action.equals("LR")) {
                showMenu();
                action = scanner.next();
                System.out.println("Введите второе значение");
                secondNumber = scanner.nextDouble();
                result = sc.operation(action, secondNumber);
            } else {
                System.out.println("Введите первое значение");
                firstNumber = scanner.nextDouble();
                System.out.println("Введите второе значение");
                secondNumber = scanner.nextDouble();
                result = sc.operation(action, firstNumber, secondNumber);
            }
        }
        return result;
    }

    /**
     * The display menu of the calculator.
     */
    public void showMenu() {
        System.out.println("Выберите дествие");
        System.out.println("+ - сложение");
        System.out.println("- - вычитание");
        System.out.println("* - умножение");
        System.out.println("/ - деление");
        System.out.println("LR - использовать последний результат");
        System.out.println("Exit - выход");
    }

    public static void main(String[] args) {
        Interact in = new Interact(new Calculator());
        in.input();
    }
}
