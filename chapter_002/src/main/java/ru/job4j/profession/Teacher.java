package ru.job4j.profession;

public class Teacher extends Profession {
    public Teacher(String name, String surName, String education, String birthday, String profession) {
        super(name, surName, education, birthday, profession);
    }

    public void learn(Student student) {
    }
}
