package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Dmitriy", "Tishchenko", "9268634025", "Vlasiha"));
        var persons = phones.find("mi");
        assertThat(persons.iterator().next().getSurname(), is("Tishchenko"));
    }
    @Test
    public void whenFindBySurName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dmitriy", "Tishchenko", "9268634025", "Vlasiha"));
        var people = phoneDictionary.find("shch");
        assertThat(people.iterator().next().getName(), is("Dmitriy"));
    }

}