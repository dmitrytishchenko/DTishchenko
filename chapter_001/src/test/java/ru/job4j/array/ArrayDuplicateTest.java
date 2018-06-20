package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenRemoveTheSameElementsThenArrayWithoutDuplicate() {
        String[] input = {"Блог", "Блог", "Блог", "Блог", "Блог"};
        String[] expect = {"Блог"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenRemoveIntegerElementsThenArrayWithoutDuplicate() {
        String[] input = {"6", "6", "7", "7", "4", "8", "4", "5", "6", "8", "8", "4", "7", "6"};
        String[] expect = {"6", "7", "8", "4", "5"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }
}