package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;
        public BishopBlack(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position(){
        return this.position;
    }
    @Override
    public Cell[] way(Cell sourse, Cell dest) throws ImposibleMoveException {
        if (Math.abs(dest.x - sourse.x) != Math.abs(dest.y - sourse.y)){
            throw new ImposibleMoveException("BishopBlack can't move like that");
        }
        int temp = 0;
        Cell [] steps = new Cell[temp];
        Cell[] values = new Cell[Math.abs(sourse.x - dest.x)];
        for (int i = 1; i < values.length ; i++) {
            if(dest.x == sourse.x + i && dest.y == sourse.y + i
                    || dest.x == sourse.x - i && dest.y == sourse.y + i
                    || dest.x == sourse.x - i && dest.y == sourse.y - i
                    || dest.x == sourse.x + i && dest.y == sourse.y - i){
                values[i] = steps[temp];
                temp++;
            }
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest){
        return new BishopBlack(dest);
    }
}
