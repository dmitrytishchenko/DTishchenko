package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer(String name, String surName, String education, String birthday, String profession) {
        super(name, surName, education, birthday, profession);
    }

    public void build(House house) {
    }
}
