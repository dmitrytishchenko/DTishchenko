package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {
    @Test
    public void way() throws Exception {
        BishopBlack bb = new BishopBlack(Cell.E5);
        Cell[] steps = new Cell[4];
        Cell[] values = new Cell[4];
         bb.way(Cell.A1, Cell.D4);
        Assert.assertEquals(steps, values );




    }

}