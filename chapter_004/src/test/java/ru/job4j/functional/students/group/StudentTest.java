package ru.job4j.functional.students.group;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void levelOf() {
        Student student1 = new Student("Alex1", 8);
        Student student2 = new Student("Vasia", 3);
        Student student3 = new Student("Bob", 9);
        Student student4 = new Student("Djon", 6);
        List<Student> list = Arrays.asList(student1, student2, student3, student4);
        List<Student> result = Student.levelOf(list, 5);
        assertThat(result, is(Arrays.asList(student1, student3, student4)));
    }
}