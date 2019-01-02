package ru.job4j.search.sortdepartment;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortDepartmentTest {
    @Test
    public void sort() throws Exception {
        String[] depart = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] expected = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        SortDepartment sortdep = new SortDepartment();
        String[] depSort = sortdep.add(depart);
        String[] result = sortdep.sort(depSort);
        assertThat(result, is(expected));
    }
    @Test
    public void reverseSort() throws Exception {
        String[] depart = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };
        String[] expected = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        SortDepartment sortdepreverse = new SortDepartment();
        String[] descendingSort = sortdepreverse.add(depart);
        String[] result = sortdepreverse.reverseSort(descendingSort);
        assertThat(result, is(expected));
    }
}