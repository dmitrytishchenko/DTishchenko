package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MatrixTest {
    @Test
    public void theTableMultiply() {
        Matrix mt = new Matrix();
        int[][] rst = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        int size = 3;
        int[][] result = mt.multiple(3);
        assertThat(result, is(rst));
    }
}













