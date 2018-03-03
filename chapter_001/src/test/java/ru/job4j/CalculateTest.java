package ru.job4j;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * Это вторая моя программа
 *@version 1.02 19.11.2017
 *@author Dmitriy Tishchenko
 */
public class CalculateTest {
    /**
     *Test echo.
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Dmitriy Tishchenko";
        String expect = "Echo, echo, echo : Dmitriy Tishchenko";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}