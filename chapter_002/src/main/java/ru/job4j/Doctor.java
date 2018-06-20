package ru.job4j;

public class Doctor extends Proffesion {
    public String diagnose;
    public void treat(Patient patient) {
    }
    public String getDiagnose() {
        return this.diagnose;
    }
    public Doctor(String name, String proffesion, String diagnose) {
        super(name, proffesion);
        this.diagnose = diagnose;
    }
}

