package ru.job4j.multithreading.threadsafe;

import net.jcip.annotations.GuardedBy;
import ru.job4j.list.DynamicArray;

import java.util.Iterator;

@net.jcip.annotations.ThreadSafe
public class ThreadSafe<E> implements IThreadSafe {
    @GuardedBy("this")
    private DynamicArray<E> array;

    public ThreadSafe() {
        this.array = new DynamicArray<E>();
    }

    @Override
    public void add(Object value) {
        this.array.add((E) value);
    }

    @Override
    public Iterator<E> iterator() {
        return copy(this.array).iterator();
    }

    public DynamicArray<E> copy(DynamicArray<E> array) {
        DynamicArray<E> result = new DynamicArray<>();
        for (int i = 0; i < array.getSize(); i++) {
            result.add(array.get(i));
        }
        return result;
    }
}
