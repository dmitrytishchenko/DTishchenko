package ru.job4j.odd.isp;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu implements MenuInterf {
    private Map<Task, String> map = new LinkedHashMap<>();

    public Menu(Map<Task, String> map) {
        this.map = map;
        init();
    }

    @Override
    public void init() {
        this.map.put(new Task("Задача 1."), new Task("Задача 1.").todo());
        this.map.put(new Task("Задача 1.1"), new Task("Задача 1.1").todo());
        this.map.put(new Task("Задача 1.1.1"), new Task("Задача 1.1.1").todo());
        this.map.put(new Task("Задача 1.1.2"), new Task("Задача 1.1.2").todo());
        this.map.put(new Task("Задача 2."), new Task("Задача 2.").todo());
        this.map.put(new Task("Задача 2.1"), new Task("Задача 2.1").todo());
    }

    @Override
    public void showMenu() {
        for (Task task : map.keySet()) {
            String[] mas = task.getName().split(" ");
            if (mas[1].equals("1.") || mas[1].equals("2.")) {
                System.out.println(String.format("%s  =>  %s", task.getName(), map.get(task)));
            } else if (mas[1].equals("1.1") || mas[1].equals("2.1")) {
                System.out.println(String.format("===== %s  =>  %s", task.getName(), map.get(task)));
            } else if (mas[1].equals("1.1.1") || mas[1].equals("1.1.2")) {
                System.out.println(String.format("========== %s  =>  %s", task.getName(), map.get(task)));
            }
        }
    }
}
