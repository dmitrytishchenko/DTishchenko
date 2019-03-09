package ru.job4j.map;


import java.util.Arrays;
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

    public boolean insert(K key, V value) {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                table[i].setValue(value);
                result = false;
            }
        }
        if (result) {
            ensureCapasity();
            table[size++] = new MyEntry<>(key, value);
        }
        return result;
    }

    public void ensureCapasity() {
        if (threshold == size) {
            int newSize = capasity * 2;
            table = Arrays.copyOf(table, newSize);
        }
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                result = table[i].getValue();
            }
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                table[i] = null;
                size--;
                result = true;
            }
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
                return carret < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент отсутствует");
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
