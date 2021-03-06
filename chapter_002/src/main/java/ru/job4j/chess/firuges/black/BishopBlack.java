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
    public Cell position() {
        return this.position;
    }
    @Override
    public Cell[] way(Cell sourse, Cell dest) throws ImposibleMoveException {
        if (Math.abs(dest.x - sourse.x) != Math.abs(dest.y - sourse.y)) {
            throw new ImposibleMoveException("BishopBlack can't move like that");
        }
        Cell[] steps = new Cell[Math.abs(sourse.x - dest.x)];
        int deltaX = Integer.compare(dest.x, sourse.x);
        int deltaY = Integer.compare(dest.y, sourse.y);
        int stepX = sourse.x;
        int stepY = sourse.y;
        for (int i = 0; i < steps.length; i++) {
            stepX += deltaX;
            stepY += deltaY;
            steps[i] = Cell.find(stepX, stepY);
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
