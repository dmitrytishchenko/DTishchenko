package ru.job4j.multithreading.nonblock;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockCash {
    private ConcurrentHashMap<Integer, Base> map;

    public NonBlockCash(ConcurrentHashMap<Integer, Base> map) {
        this.map = map;
    }

    public void add(Base model) {
        this.map.put(model.getId(), model);
    }

    public synchronized void update(Base model) {
        this.map.computeIfPresent(model.getId(), (id, base) -> {
            if (model.getVersion() != getVers(model)) {
                throw new OptimisticException("Версия не совпадает!");
            }
            if (base.getId() == model.getId()) {
                base = model;
                increment(base);
            }
            return base;
        });
    }

    public void delete(Base model) {
        if (this.map.size() > 0) {
            this.map.remove(model.getId(), model);
        }
    }

    public synchronized int getVers(Base model) {
        return this.map.get(model.getId()).getVersion();
    }

    public synchronized void increment(Base model) {
        model.setVersion(model.getVersion() + 1);
    }
}

