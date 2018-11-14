package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private int position = 0;
    private static final Random RANDOM = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    public boolean replace(String id, Item item) {
        boolean repl = false;
        for (int i = 0; i != this.position; i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(items.get(i).getId());
                items.add(item);
                repl = true;
                break;
            }
        }
        return repl;
    }
    public boolean delete(String id) {
        boolean result = false;
        for (Item value : items) {
            if (value.getId().equals(id)) {
                result = true;
            }
            this.items.remove(value);
            break;
        }
        return result;
    }
    public ArrayList<Item> findAll() {
        for (Item value : this.items){
            if (value != null){
                break;
            }
        }
        return this.items;
    }
    public ArrayList<Item> findByName(String key) {
        for (Item temp: this.items) {
            if (temp != null && key.equals(temp.getName())) {
                break;
            }
        }
        return items;
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
