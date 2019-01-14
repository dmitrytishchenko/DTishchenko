package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, OccupiedWayException, ImposibleMoveException {
        boolean result = false;
        int index = this.findBy(source);
        if (index != -1) {
            throw new FigureNotFoundException("figure not found in cell.");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (Cell cell : steps) {
            if (findBy(cell) != -1) {
                throw new OccupiedWayException("The cell is occupied.");
            }
        }
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            result = true;
        }
        return result;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        return IntStream.range(0, this.figures.length)
                .filter(n -> this.figures[n].position().equals(cell))
                .findFirst().orElse(-1);
//        int rst = -1;
//        for (int index = 0; index != this.figures.length; index++) {
//            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
//                rst = index;
//                break;
//            }
//        }
//        return rst;
    }
}
