package ru.job4j.odd.spr;

import ru.job4j.calculator.Calculator;
import ru.job4j.odd.spr.ocp.Action;

import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * Operation of standard calculator.
 */
public class StandardCalculator implements Add, Action {
    /**
     * Map dispatch, with key - String and value - BiFunction.
     */
    private Map<String, BiFunction<Double, Double, Double>> dispatch;
    /**
     * Object Calculator.
     */
    private Calculator calculator = new Calculator();
    /**
     * Variable lastResult to record the last result.
     */
    private double lastResult = 0;

    public StandardCalculator(Map<String, BiFunction<Double, Double, Double>> dispatch) {
        this.dispatch = dispatch;
        init();
    }

    /**
     * Method of adding.
     *
     * @return BiFunction
     */
    @Override
    public BiFunction<Double, Double, Double> add() {
        return (first, second) -> {
            calculator.add(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    /**
     * Subtraction method.
     *
     * @return BiFunction
     */
    public BiFunction<Double, Double, Double> subtract() {
        return (first, second) -> {
            calculator.subtract(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    /**
     * Method of multiplication.
     *
     * @return BiFunction
     */
    public BiFunction<Double, Double, Double> multiple() {
        return (first, second) -> {
            calculator.multiple(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    /**
     * Method of dividing.
     *
     * @return BiFunction
     */
    public BiFunction<Double, Double, Double> div() {
        return (first, second) -> {
            calculator.div(first, second);
            System.out.println(String.format("Последний результат равен - %f", calculator.getResult()));
            return calculator.getResult();
        };
    }

    public void load(String action, BiFunction<Double, Double, Double> handle) {
        this.dispatch.put(action, handle);
    }

    /**
     * Loading calculator actions into the map.
     *
     * @return StandardCalculator
     */
    public StandardCalculator init() {
        this.load("+", this.add());
        this.load("-", this.subtract());
        this.load("*", this.multiple());
        this.load("/", this.div());
        return this;
    }

    /**
     * @param op     - operation.
     * @param first  - first number.
     * @param second - second number.
     * @return - the result of the calculator.
     */
    public double operation(String op, double first, double second) {
        this.lastResult = dispatch.get(op).apply(first, second);
        return lastResult;
    }

    /**
     * @param op     - operation.
     * @param second - second number.
     * @return - the result of the calculator.
     */
    public double oper(String op, double second) {
        return dispatch.get(op).apply(lastResult, second);
    }

    @Override
    public double calc(String input) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        System.out.println("Введите первое значение");
        firstNumber = scanner.nextDouble();
        System.out.println("Введите второе значение");
        secondNumber = scanner.nextDouble();
        return this.dispatch.get(input).apply(firstNumber, secondNumber);
    }
}
