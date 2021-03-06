package ru.job4j;

import org.junit.Test;
import ru.job4j.figure.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
        .append("  +  ")
        .append(" ++ ")
        .append(" +++ ")
        .append("+++++")
        .toString()));
    }

}