package ru.job4j.profession;

public class Doctor extends Profession {
    public String diagnose;

    public Doctor(String name, String surName, String education, String birthday, String profession, String diagnose) {
        super(name, surName, education, birthday, profession);
        this.diagnose = diagnose;
    }

    public void treat(Patient patient) {
    }

    public String getDiagnose() {
        return this.diagnose;
    }

}


