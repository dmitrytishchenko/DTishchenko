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

    public void update(Base model) {
        this.map.computeIfPresent(model.getId(), (id, base) -> {
            if (model.getVersion() != this.map.get(model.getId()).getVersion()) {
                throw new OptimisticException("Версия не совпадает!");
            }
            while (base.getId() == model.getId()) {
                base = model;
                base.setVersion(model.getVersion() + 1);
            }
            return base;
        });

    }

    public void delete(Base model) {
        if (this.map.size() > 0) {
            this.map.remove(model.getId(), model);
        }
    }
}

