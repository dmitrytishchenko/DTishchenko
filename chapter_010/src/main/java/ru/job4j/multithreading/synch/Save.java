package ru.job4j.multithreading.synch;

import ru.job4j.list.DynamicArray;

public class Save<T> {
    private final DynamicArray<T> list;

    public Save(DynamicArray<T> list) {
        this.list = list;
    }

    public DynamicArray<T> getList() {
        return list;
    }
}
