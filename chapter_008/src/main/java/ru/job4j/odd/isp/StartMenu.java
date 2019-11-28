package ru.job4j.odd.isp;

import java.util.LinkedHashMap;
import java.util.Map;

public class StartMenu {
    public static void main(String[] args) {
        Map<Task, String> map = new LinkedHashMap<>();
        new Menu(map).showMenu();
    }
}
