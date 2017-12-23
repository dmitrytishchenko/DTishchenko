package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenClassicSearch() {
        FindLoop fp = new FindLoop();
        int[] rsl = {0, 1, 2, 3};
        int result = fp.indexOf(rsl, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenClassicSearchh() {
        FindLoop fp = new FindLoop();
        int[] rsl = {0, 1, 2, 3};
        int result = fp.indexOf(rsl, 5);
        assertThat(result, is(-1));
    }
}
