package ru.job4j.multithreading.threadsafe;

import java.util.Iterator;

public interface IThreadSafe<E> {
    void add(E value);
    Iterator<E> iterator();
}
