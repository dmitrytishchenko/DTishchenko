package ru.job4j.generics;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> massiv;
    public AbstractStore(int size) {
        this.massiv = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.massiv.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < this.massiv.getLenght(); i++) {
            if (this.massiv.get(i).getId().equals(id)) {
                this.massiv.set(i, model);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.massiv.getLenght(); i++) {
            if (this.massiv.get(i).getId().equals(id)) {
                this.massiv.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T t : this.massiv) {
            if (t.getId().equals(id)) {
                result = t;
            }
        }
        return result;
    }
}
