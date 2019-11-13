package ru.job4j.odd.spr.ocp;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class EngineerCalculator implements Action {
    private Map<String, Function<Double, Double>> dispatch;

    public EngineerCalculator(Map<String, Function<Double, Double>> dispatch) {
        this.dispatch = dispatch;
        this.init();
    }

    public Function<Double, Double> sin() {
        return value -> Math.sin(value);
    }

    public Function<Double, Double> cos() {
        return value -> Math.cos(value);
    }

    public Function<Double, Double> tan() {
        return value -> Math.tan(value);
    }

    public Function<Double, Double> asin() {
        return value -> Math.asin(value);
    }

    public Function<Double, Double> acos() {
        return value -> Math.acos(value);
    }

    public Function<Double, Double> atan() {
        return value -> Math.atan(value);
    }

    public void load(String action, Function<Double, Double> func) {
        this.dispatch.put(action, func);
    }

    public EngineerCalculator init() {
        this.load("sin", this.sin());
        this.load("cos", this.cos());
        this.load("tan", this.tan());
        this.load("asin", this.asin());
        this.load("acos", this.acos());
        this.load("atan", this.atan());
        return this;
    }

    @Override
    public double calc(String input) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber;
        System.out.println("Введите значение");
        firstNumber = scanner.nextDouble();
        return this.dispatch.get(input).apply(firstNumber);
    }
}
