package ru.job4j.multithreading.synch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this.")
    private DynamicArray<T> list = new DynamicArray();

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

    public synchronized DynamicArray<T> save(DynamicArray<T> list) {
        new Storage<T>().setList(list);
        return new Storage<T>().getList();
    }

    public synchronized DynamicArray<T> copy(DynamicArray<T> list) {
        Storage<T> st = new Storage<>();
        st.setList(new SingleLockList<T>().save(list));
        st.setList(list);
        return st.getList();
    }
}
