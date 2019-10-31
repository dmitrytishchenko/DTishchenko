package ru.job4j.odd.spr;

public interface Action {
    Type type();

    enum Type {
        add,
        subtract,
        multiple,
        div
    }
}
