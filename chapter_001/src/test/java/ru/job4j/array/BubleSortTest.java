package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubleSort bs = new BubleSort();
        int[] array = {10, 8, 1, 9, 2, 7, 6, 5, 3, 4, 0};
        int[] result = bs.sort(array);
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
    }

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray2() {
        BubleSort bs = new BubleSort();
        int[] array = {1, 2, 5, 3, 4, 0};
        int[] result = bs.sort(array);
        int[] expected = {0, 1, 2, 3, 4, 5};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
    }
}



