package ru.job4j.odd.isp;

public class Task implements TaskInterf {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String todo() {
        return "Выполнение задачи ";
    }
}
