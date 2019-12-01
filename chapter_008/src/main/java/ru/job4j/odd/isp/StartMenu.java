package ru.job4j.odd.isp;

import java.util.Map;
import java.util.TreeMap;

public class StartMenu {
    public static void main(String[] args) {
        Map<String, Task> map = new TreeMap<>();
        new Menu(map).showMenu();
    }
}
