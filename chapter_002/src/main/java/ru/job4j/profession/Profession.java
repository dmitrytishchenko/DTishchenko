package ru.job4j.profession;

public class Profession {
    public String name;
    public String surName;
    public String education;
    public String birthday;
    public String profession;

    public Profession(String name, String surName, String education, String birthday, String profession) {
        this.name = name;
        this.surName = surName;
        this.education = education;
        this.birthday = birthday;
        this.profession = profession;
    }


    public String getName() {
        return this.name;
    }


}
