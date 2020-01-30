package ru.job4j.multithreading.synch;

import ru.job4j.list.DynamicArray;

public class Storage<T> {
    private DynamicArray<T> list;

    public DynamicArray<T> getList() {
        return list;
    }

    public void setList(DynamicArray<T> list) {
        this.list = list;
    }
}
