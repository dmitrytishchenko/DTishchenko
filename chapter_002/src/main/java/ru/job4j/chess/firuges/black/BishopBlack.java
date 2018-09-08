package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;
    public BishopBlack(final Cell position){
        this.position = position;
    }
    @Override
    public Cell position(){
        return this.position;
    }
    @Override
    public Cell[] way(Cell sourse, Cell dest) throws ImposibleMoveException {
        if (dest.x - sourse.x != dest.y - sourse.y){
            throw new ImposibleMoveException("BishopBlack can't move like that");
        }
        Cell[] steps = new Cell[0];
        for (int i = 0; i < steps.length ; i++) {
            if(dest.x == sourse.x + i && dest.y == sourse.y + i
                    || dest.x == sourse.x - i && dest.y == sourse.y + i
                    || dest.x == sourse.x - i && dest.y == sourse.y - i
                    || dest.x == sourse.x + i && dest.y == sourse.y - i){
                steps = new Cell[]{dest};
            }
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest){
        return new BishopBlack(dest);
    }
}
