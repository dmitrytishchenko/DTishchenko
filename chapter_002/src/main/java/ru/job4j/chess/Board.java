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
        for (int i = 0; i < this.figures.length; i++) {
            if (figures[i] != null && !figures[i].equals(source)) {
                throw new FigureNotFoundException("Figure not found in cell.");
            }
            Cell[] steps = figures[i].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            } else {
                throw new ImposibleMoveException("The figure can not move.");
            }
            if (figures[i].copy(dest) == null) {
                throw new OccupiedWayException("The cell is occupied.");
            }break;
        }
        return result;
    }
}




