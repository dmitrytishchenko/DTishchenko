package ru.job4j.odd.spr.ocp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EngineerCalculator {
    private Map<String, Function<Double, Double>> dispatch = new HashMap<>();

    public EngineerCalculator(Map<String, Function<Double, Double>> dispatch) {
        this.dispatch = dispatch;
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

    public double operation(String op, double value) {
        return this.dispatch.get(op).apply(value);
    }
}
