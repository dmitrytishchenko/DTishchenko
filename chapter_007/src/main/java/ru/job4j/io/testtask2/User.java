package ru.job4j.io.testtask2;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> email = new ArrayList<>();
    private static String name;

    public List<String> getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
