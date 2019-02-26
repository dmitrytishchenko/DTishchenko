package ru.job4j.set;

import ru.job4j.list.DynamicArray;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    /**
     Реализовать коллекцию SimpleSet.
     Коллекция должна обеспечивать void add(E e) и реализовывать Iterable<E>.
     Коллекция не должна хранить дубликаты.
     Set - внутри для хранения данных использует обычные массивы.
     Код будет идентичным, как и в SimpleList(Это код из задания реализации списка на массиве).
     Как можно за счет композиции сократить количества кода?
     Здесь нужно использовать SimpleList в реализации SimpleSet.
     */
    private DynamicArray<E> set;
    private int size;

    public SimpleSet(int size) {
        this.set = new DynamicArray(size);
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }
    public void add(E date) {
        if (!dublicate(date)) {
            this.set.add(date);
        }
    }

    public boolean dublicate(E date) {
        boolean result = false;
        for (E e : set) {
            if (e.equals(date)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.set.iterator();
    }

}
