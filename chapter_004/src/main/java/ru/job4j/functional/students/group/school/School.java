package ru.job4j.functional.students.group.school;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
    public static Map<String, Student> collect2(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurName, s -> s));
    }
}
