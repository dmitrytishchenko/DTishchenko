package ru.job4j.loop;
import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author Tishchenko Dmitry
 * @version 2.08
 */
public class PaintTest {
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("^   ")
                .add("^^  ")
                .add("^^^ ")
                .add("^^^^")
                .toString()
        ));
        System.out.println(rst);
    }
    @Test
    public void whenPyramidLeft() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^")
                .add("  ^^")
                .add(" ^^^")
                .add("^^^^")
                .toString()
        )); System.out.println(rst);
    }
    @Test
    public void pyramid() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString()
        )); System.out.println(rst);
    }
}
