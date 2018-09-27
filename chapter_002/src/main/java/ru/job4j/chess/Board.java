package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;


public class Board {
    Figure[] figures = new Figure[32];
    int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        int index = this.findBy(source);
        if(index == -1){
            throw new FigureNotFoundException("Figure not found in cell.");
        }
        Cell[] steps = figures[index].way(source, dest);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
        } else {
            throw new ImposibleMoveException("The figure can not move.");
        }
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            result = true;
        } else {
            throw new OccupiedWayException("The cell is occupied.");
        }
        return result;
    }
}





