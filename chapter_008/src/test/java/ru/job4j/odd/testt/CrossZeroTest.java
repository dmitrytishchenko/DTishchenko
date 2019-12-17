package ru.job4j.odd.testt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CrossZeroTest {

    @Test
    public void whenWinXInLine1() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][0] = "X";
        cr.getField()[0][1] = "X";
        cr.getField()[0][2] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInLine2() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[1][0] = "X";
        cr.getField()[1][1] = "X";
        cr.getField()[1][2] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInLine3() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[2][0] = "X";
        cr.getField()[2][1] = "X";
        cr.getField()[2][2] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInLine4() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][0] = "X";
        cr.getField()[1][0] = "X";
        cr.getField()[2][0] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInLine5() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][1] = "X";
        cr.getField()[1][1] = "X";
        cr.getField()[2][1] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInLine6() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][2] = "X";
        cr.getField()[1][2] = "X";
        cr.getField()[2][2] = "X";
        boolean result = cr.checkLines("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInDiagonale1() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][0] = "X";
        cr.getField()[1][1] = "X";
        cr.getField()[2][2] = "X";
        boolean result = cr.checkDiagonal("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinXInDiagonale2() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][2] = "X";
        cr.getField()[1][1] = "X";
        cr.getField()[2][0] = "X";
        boolean result = cr.checkDiagonal("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinX() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][2] = "X";
        cr.getField()[1][1] = "X";
        cr.getField()[2][0] = "X";
        boolean result = cr.winX("X");
        assertThat(result, is(true));
    }

    @Test
    public void whenWinO() {
        CrossZero cr = new CrossZero(3);
        cr.getField()[0][2] = "O";
        cr.getField()[1][1] = "O";
        cr.getField()[2][0] = "O";
        boolean result = cr.winX("O");
        assertThat(result, is(true));
    }
}