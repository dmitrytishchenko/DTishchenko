package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public abstract class Figure {
    final Cell position;
    Figure(Cell position){
        this.position = position;
    }
    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
    abstract Figure copy (Cell dest);
}
