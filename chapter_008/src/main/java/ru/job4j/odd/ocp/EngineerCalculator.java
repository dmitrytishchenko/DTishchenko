package ru.job4j.odd.ocp;

import ru.job4j.odd.spr.StandardCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EngineerCalculator extends StandardCalculator implements Action {
    private Map<String, Function<Double, Double>> engineMap = new HashMap<>();
    private StandardCalculator sc = new StandardCalculator(dispatch);

    public EngineerCalculator(Map<String, Function<Double, Double>> engineMap, Map<String, BiFunction<Double, Double, Double>> disp) {
        super(disp);
        this.engineMap = engineMap;
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
        this.engineMap.put(action, func);
    }

    public EngineerCalculator init() {
        super.init();
        this.engineMap = new HashMap<>();
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
        double result;
        if (this.engineMap.keySet().contains(input)) {
            Scanner scanner = new Scanner(System.in);
            double firstNumber;
            System.out.println("Введите значение");
            firstNumber = scanner.nextDouble();
            result = this.engineMap.get(input).apply(firstNumber);
            System.out.println(result);
        } else {
            result = sc.calc(input);
        }
        return result;
    }
}