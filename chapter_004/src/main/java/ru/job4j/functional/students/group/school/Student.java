package ru.job4j.functional.students.group.school;

public class Student {
    public int score;
    private String surName;

    public Student(int score) {
        this.score = score;
    }

    public Student() {
    }

    public Student(String surName) {
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }
}
