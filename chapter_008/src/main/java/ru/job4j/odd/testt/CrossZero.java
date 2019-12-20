package ru.job4j.odd.testt;

import java.util.Random;
import java.util.Scanner;

public class CrossZero implements Win, ShowField, Players, Start {
    private int size;
    private int horiz;
    private int vertical;
    private String[][] field;
    private Scanner scanner = new Scanner(System.in);

    public CrossZero(int size) {
        this.size = size;
        this.field = new String[size][size];
    }

    @Override
    public void printField() {
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field.length; j++) {
                System.out.print(this.field[i][j]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    @Override
    public void startPlayerToComp() {
        printField();
        boolean run = true;
        while (run) {
            playerMove("X");
            printField();
            if (win()) {
                break;
            }
            playerCompMove("O");
            printField();
            if (win()) {
                break;
            }
        }
    }

    @Override
    public void startCompToComp() {
        printField();
        boolean run = true;
        while (run) {
            playerCompMove("X");
            printField();
            if (win()) {
                break;
            }
            playerCompMove("O");
            printField();
            if (win()) {
                break;
            }
        }
    }

    @Override
    public boolean win() {
        boolean result = false;
        if (winX("X") || winO("O")) {
            result = true;
        }
        return result;
    }


    @Override
    public void playerMove(String str) {
        System.out.println("Ход предоставляется игроку.");
        System.out.println("Введите ход по вертикали");
        this.vertical = scanner.nextInt();
        System.out.println("Введите ход по горизонтали");
        this.horiz = scanner.nextInt();
        if (this.field[this.vertical][this.horiz] == null) {
            this.field[this.vertical][this.horiz] = str;
        } else {
            System.out.println("Данное поле занято, сделайте ход заново");
            playerMove(str);
        }
    }

    @Override
    public void playerCompMove(String str) {
        System.out.println("Ход предоставляется компьютеру.");
        Random random = new Random();
        int horizO = random.nextInt(size);
        int verticalO = random.nextInt(size);
        if (this.field[verticalO][horizO] == null) {
            this.field[verticalO][horizO] = str;
        } else {
            System.out.println("Данное поле занято, сделайте ход заново");
            playerCompMove(str);
        }
    }

    @Override
    public boolean winX(String symb) {
        boolean result = false;
        if (checkLines(symb) || checkDiagonal(symb)) {
            result = true;
            System.out.println("Win player with X !!!!!!");
        }
        return result;
    }

    @Override
    public boolean winO(String symb) {
        boolean result = false;
        if (checkLines(symb) || checkDiagonal(symb)) {
            result = true;
            System.out.println("Win player with O !!!!!!");
        }
        return result;
    }

    @Override
    public boolean checkDiagonal(String symb) {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            result = result & (this.field[i][i] == symb) || result & (this.field[i][size - 1 - i] == symb);
        }
        return result;
    }

    @Override
    public boolean checkLines(String symb) {
        boolean cols;
        boolean rows;
        boolean result = false;
        for (int i = 0; i < size; i++) {
            cols = true;
            rows = true;
            for (int j = 0; j < size; j++) {
                cols &= (this.field[i][j] == symb);
                rows &= (this.field[j][i] == symb);
            }
            if (cols || rows) {
                result = true;
            }
        }
        return result;
    }

    public String[][] getField() {
        return field;
    }
}

