package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;
import ru.job4j.odd.spr.ocp.Action;
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
    private StandardCalculator sc = new StandardCalculator(dispatch);
    private Map<String, Function<Double, Double>> engineerMap = new HashMap<>();
    private EngineerCalculator ec = new EngineerCalculator(engineerMap);


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
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Калькулятор готов к работе");
        Action ec = new EngineerCalculator(engineerMap);
        while (run) {
            showMenu();
            operation = scanner.next();
            if ("Exit".equals(operation)) {
                System.out.println("Калькулятор завершил свою работу");
                break;
            } else if ("LR".equals(operation)) {
                showMenu();
                operation = scanner.next();
                System.out.println("Введите второе значение");
                double secondNumber = scanner.nextDouble();
                result =  sc.oper(operation, secondNumber);
            } else {
//                result = sc.calc(operation);
                result = ec.calc(operation);
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