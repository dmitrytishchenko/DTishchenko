package ru.job4j.multithreading.synch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this.")
    private DynamicArray<T> list = new DynamicArray();

    public SingleLockList() {
    }

    public synchronized void add(T value) {
        this.list.add(value);
    }

    public synchronized T get(int index) {
        return this.list.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    public Save<T> save(DynamicArray<T> list) {
        return new Save<>(list);
    }

    public synchronized DynamicArray<T> copy(DynamicArray<T> list) {
        Save<T> save = save(list);
        Storage<T> st = new Storage<>();
        st.setSave(save);
        return st.getSave().getList();
    }
}
