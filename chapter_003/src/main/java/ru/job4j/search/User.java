package ru.job4j.search;

public class User {
    private String name;
    private Integer id;
    private String city;

    public User(String name, Integer id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
