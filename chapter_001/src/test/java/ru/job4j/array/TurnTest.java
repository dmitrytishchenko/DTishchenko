package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn tn = new Turn();
        int[] array = {2, 6, 1, 4};
        int[] result = tn.back(array);
        assertThat(result, is(array));
    }
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArrayy() {
        Turn tn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        int[] result = tn.back(array);
        assertThat(result, is(array));
    }
}
