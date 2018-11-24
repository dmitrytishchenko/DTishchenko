package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Dmitriy", "Tishchenko", "9268634025", "Vlasiha"));
        List<Person> persons = phones.find("mi");
        assertThat(persons.iterator().next().getSurname(), is("Tishchenko"));
    }

}