package ru.job4j.parser;

import java.util.Objects;

public class Vacancy {
    private String name;
    private String text;
    private String link;

    public Vacancy(String name, String text, String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(name, vacancy.name)
                && Objects.equals(text, vacancy.text)
                && Objects.equals(link, vacancy.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text, link);
    }
}
