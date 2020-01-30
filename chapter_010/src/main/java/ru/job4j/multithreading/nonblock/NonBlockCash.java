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
        if (model.getVersion() != this.map.get(model.getId()).getVersion()) {
            throw new OptimisticException("Версия не совпадает!");
        }
        this.map.computeIfPresent(model.getId(), (id, base) -> {
            if (base.getId() == model.getId()) {
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

//    public static void main(String[] args) {
//        NonBlockCash cash = new NonBlockCash();
//        Base base1 = new Base();
//        base1.setId(1);
//        base1.setVersion(1);
//        Base base2 = new Base();
//        base2.setId(2);
//        base2.setVersion(1);
//        cash.add(base1);
//        cash.add(base2);
//        Base base3 = new Base();
//        base3.setId(1);
//        base3.setVersion(1);
//        cash.update(base3);
//        System.out.println(cash.map.get(1).getVersion());
//    }
}

