package ru.job4j.odd.testt;

public interface Win {
    boolean win();
    boolean winX(String symb);
    boolean winO(String symb);
    boolean checkDiagonal(String symb);
    boolean checkLines(String symb);
}
