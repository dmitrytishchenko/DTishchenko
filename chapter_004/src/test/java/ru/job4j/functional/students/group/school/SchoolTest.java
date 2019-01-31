package ru.job4j.functional.students.group.school;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    Student student1 = new Student(75);
    Student student2 = new Student(18);
    Student student3 = new Student(93);
    Student student4 = new Student(54);
    Student student5 = new Student(40);
    Student student6 = new Student(30);
    List<Student> list = Arrays.asList(student1, student2, student3, student4, student5, student6);
    @Test
    public void receiveListA() {
        List<Student> result = School.collect(list, n-> n.score > 70);
        assertThat(result, is(Arrays.asList(student1, student3)));
    }
    @Test
    public void receiveListB() {
        List<Student> result = School.collect(list, n-> n.score < 70 && n.score > 50);
        assertThat(result, is(Arrays.asList(student4)));
    }
    @Test
    public void receiveListC() {
        List<Student> result = School.collect(list, n-> n.score < 50);
        assertThat(result, is(Arrays.asList(student2, student5, student6)));
    }
}