package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    public boolean replace(String id, Item item) {
        boolean repl = false;
        for (Item item1 : this.items) {
            int value = 0;
            if (item1 != null && item1.getId().equals(id)) {
                this.items.set(value, item);
                repl = true;
                break;
            }
            value++;
        }
        return repl;
    }
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }
    public List<Item> findAll() {
        return this.items;
    }
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item temp: this.items) {
            if (temp != null && key.equals(temp.getName())) {
                result.add(temp);
            }
        }
        return result;
    }
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }

    protected String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tracker tracker = (Tracker) o;

        return items.equals(tracker.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}
