package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenToFillTheArrayElementsSquared() {
        Square sq = new Square();
        int[] rst = {1, 4, 9};
        int[] result = sq.calculate(3);
        assertThat(result, is(rst));
    }
    @Test
    public void whenToFillTheArrayElementsSquaredd() {
        Square sq = new Square();
        int[] rst = {1, 4, 9, 16, 25};
        int[] result = sq.calculate(5);
        assertThat(result, is(rst));
    }
}
