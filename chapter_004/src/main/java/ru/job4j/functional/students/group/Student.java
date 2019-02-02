package ru.job4j.functional.students.group;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
    public Student() {
    }
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparing(Student::getName))
                .takeWhile(n -> n.getScope() > bound)
                .collect(Collectors.toList());
    }
    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", scope=" + scope + '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
