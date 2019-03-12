package ru.job4j.map;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleHashMap<K, V> implements Iterable<K> {
    /**
     * Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
     * boolean insert(K key, V value);
     * V get(K key);
     * boolean delete(K key);
     * Реализовывать итератор.
     * Внутренняя реализация должна использовать массив.
     * Нужно обеспечить фиксированное время вставки и получение.
     * Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
     * Методы разрешения коллизий реализовывать не надо.
     * Например: если при добавлении ключ уже есть, то возвращать false.
     */
    private MyEntry<K, V>[] table;
    private final float loadFactor = 0.75f;
    private int capasity = 16;
    private float threshold = capasity * loadFactor;
    private int size = 0;

    public SimpleHashMap() {
        this.table = new MyEntry[capasity];
    }

    public static int indexFor(int h, int lenght) {
        return h & (lenght - 1);
    }

    public boolean insert(K key, V value) {
        boolean result = true;
        int index = indexFor(key.hashCode(), table.length);
        if (table[index] == null) {
            ensureCapasity();
            table[index] = new MyEntry<>(key, value);
            size++;
        } else {
            if (table[index].key.equals(key)) {
                table[index].setValue(value);
            }
        }
        return result;
    }

    public void ensureCapasity() {
        if (table.length == capasity) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        int newCapasity = capasity * 2;
        MyEntry[] newTable = new MyEntry[newCapasity];
        trasfer(newTable);
        table = newTable;
        threshold = (int) (newCapasity * loadFactor);
    }

    public void trasfer(MyEntry[] newTable) {
        int newCapacity = newTable.length; // новый размер массива
        for (int i = 0; i < table.length; i++) { // проходим по старому массиву через цикл
            while (table[i] != null) { // условие, пока не закончатся элементы
                int index = indexFor(table[i].hash, newCapacity); // находим новые бакеты для всех элементов на основе новой длинны
                newTable[index] = table[i]; // помещаем элементы из старого массива в новый по индексам(бакетам)
            }
        }
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        V result = null;
        int index = indexFor(key.hashCode(), table.length);
        if (table[index].key.equals(key)) {
            result = table[index].getValue();
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexFor(key.hashCode(), table.length);
        if (table[index].key.equals(key)) {
            table[index] = null;
            size--;
            result = true;
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {K}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int carret = 0;

            @Override
            public boolean hasNext() {
                return carret <= size;
            }

            @Override
            public K next() {
                while (table[carret] == null && carret < table.length) {
                    carret++;
                }
                if (carret > table.length) {
                    throw new NoSuchElementException("No element");
                }
                return (K) table[carret++].key;
            }
        };
    }

    private class MyEntry<K, V> {
        private final K key;
        private V value;
        int hash;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 * key.hashCode();
            hash = hash * 17 * value.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            boolean result = false;
            if (this == o) {
                result = true;
            }
            if (o instanceof MyEntry) {
                MyEntry<K, V> entry = (MyEntry) o;
                result = Objects.equals(key, entry.getKey())
                        && Objects.equals(value, entry.getValue())
                        || Objects.equals(hash, entry.hashCode());
            }
            return result;
        }
    }
}
