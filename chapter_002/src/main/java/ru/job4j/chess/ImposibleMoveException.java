package ru.job4j.chess;

public class ImposibleMoveException extends Exception{
    public ImposibleMoveException(String msg){
        super(msg);
    }
}
