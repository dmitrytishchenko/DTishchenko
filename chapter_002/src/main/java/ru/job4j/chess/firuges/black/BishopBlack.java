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
        Cell[] steps = new Cell[Math.abs(sourse.x - dest.x)];
        int deltaX = 1;
        int deltaY = 1;
        for (int i = 0; i < steps.length ; i++) {
            steps[i] = Cell.find(sourse.x + deltaX, sourse.y + deltaY);
        }
        return steps;

    }
    @Override
    public Figure copy(Cell dest){
        return new BishopBlack(dest);
    }
}
