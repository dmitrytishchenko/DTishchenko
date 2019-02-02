package ru.job4j.functional;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenConvertMatrixToList() {
        Matrix matrix = new Matrix();
        Integer[][] mas = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> expected = List.of(
                List.of(1,2,3,4,5,6,7,8,9));
        List<List<Integer>> result = matrix.convert(mas);
        assertThat(result, is(expected));
    }
}