package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {
    @Test
    public void way() throws RuntimeException {
        BishopBlack bb = new BishopBlack(Cell.A1);
        Cell[] expect = {Cell.B2, Cell.C3, Cell.D4};
        Cell[] result =  bb.way(Cell.A1, Cell.D4);
        Assert.assertEquals(result, expect);
    }
    @Test
    public void way2() throws RuntimeException {
        BishopBlack bb = new BishopBlack(Cell.D4);
        Cell[] expect = {Cell.E5, Cell.F6};
        Cell[] result =  bb.way(Cell.D4, Cell.F6);
        Assert.assertEquals(result, expect);
    }
    @Test
    public void way3() throws RuntimeException {
        BishopBlack bb = new BishopBlack(Cell.D4);
        Cell[] expect = {Cell.C5};
        Cell[] result =  bb.way(Cell.D4, Cell.C5);
        Assert.assertEquals(result, expect);
    }
    @Test
    public void way4() throws RuntimeException {
        BishopBlack bb = new BishopBlack(Cell.D4);
        Cell[] expect = {Cell.C3};
        Cell[] result =  bb.way(Cell.D4, Cell.C3);
        Assert.assertEquals(result, expect);
    }
    @Test
    public void way5() throws RuntimeException {
        BishopBlack bb = new BishopBlack(Cell.D4);
        Cell[] expect = {Cell.E3, Cell.F2, Cell.G1};
        Cell[] result =  bb.way(Cell.D4, Cell.G1);
        Assert.assertEquals(result, expect);
    }
}