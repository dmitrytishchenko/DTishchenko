package ru.job4j.functional;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MassivStreamTest {

    @Test
    public void sumStream() {
        int[] mas = new int[]{1, 2, 3, 4, 5};
        int sum = 20;
        MassivStream massivStream = new MassivStream();
        int result = massivStream.sumStream(mas);
        assertThat(result, is(sum));
    }
}