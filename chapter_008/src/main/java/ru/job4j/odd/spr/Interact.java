package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;
import ru.job4j.odd.spr.ocp.EngineerCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

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
    private Map<String, Function<Double, Double>> engineerMap = new HashMap<>();

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
        EngineerCalculator ec = new EngineerCalculator(this.engineerMap);
        ec.init();
        sc.init();
        Scanner scanner = new Scanner(System.in);
        String action;
        double firstNumber;
        double secondNumber;
        System.out.println("Калькулятор готов к работе");
        while (run) {
            showMenu();
            action = scanner.next();
            if ("Exit".equals(action)) {
                System.out.println("Калькулятор завершил свою работу");
                break;
            } else if ("LR".equals(action)) {
                showMenu();
                action = scanner.next();
                System.out.println("Введите второе значение");
                secondNumber = scanner.nextDouble();
                result = sc.operation(action, secondNumber);
            } else if ("sin".equals(action) || "cos".equals(action) || "tan".equals(action)
                    || "asin".equals(action) || "acos".equals(action) || "atan".equals(action)) {
                System.out.println("Введите значение");
                firstNumber = scanner.nextDouble();
                result = ec.operation(action, firstNumber);
                System.out.println(String.format("Результат равен %s", result));
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
        System.out.println("sin - синус угла");
        System.out.println("cos - косинус угла");
        System.out.println("tan - тангенс угла");
        System.out.println("asin - арксинус угла");
        System.out.println("acos - арккосинус угла");
        System.out.println("atan - арктангенс угла");
        System.out.println("LR - использовать последний результат");
        System.out.println("Exit - выход");
    }

    public static void main(String[] args) {
        Interact it = new Interact(new Calculator());
        it.input();
    }
}
