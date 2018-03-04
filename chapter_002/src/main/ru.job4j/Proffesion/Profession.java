package ru.job4j.Proffesion;
public class Proffesion {
    public String name;
    public String proffesion;
    public Proffesion(){
    }
    public Proffesion(String name,String proffesion){
        this.name = name;
        this.proffesion = proffesion;
    }
    public String getName() {
        return this.name;
    }
    public String getProffesion() {
        return this.proffesion;
    }
}
