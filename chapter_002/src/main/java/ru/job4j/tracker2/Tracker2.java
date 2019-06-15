package ru.job4j.tracker2;

import ru.job4j.tracker.Item;

import java.util.Random;

public class Tracker2 {
    private Item[] items2 = new Item[100];
    int position = 0;
    private static final Random RANDOM = new Random();

    public int getPosition() {
        return this.position;
    }

    public Item add2(Item item) {
        item.setId(this.generateId());
        items2[this.position++] = item;
        return item;
    }

    public boolean replace2(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items2.length; i++) {
            if (items2[i].getId().equals(id)) {
                items2[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete2(String id) {
        boolean result = false;
        for (int i = 0; i < items2.length; i++) {
            if (items2[i] != null && items2[i].getId().equals(id)) {
                System.arraycopy(items2, i + 1, items2, i, items2.length - 1 - i);
                result = true;
            }
        }
        return result;
    }

    public Item[] findAll2() {
        return this.items2;
    }

    public Item findByName2(String key) {
        Item result = null;
        for (int i = 0; i < items2.length; i++) {
            if (items2[i] != null && items2[i].getName().equals(key)) {
                result = items2[i];
                break;
            }
        }
        return result;
    }

    public Item findById2(String id) {
        Item result = null;
        for (int i = 0; i < items2.length - 1; i++) {
            if (items2[i] != null && items2[i].getId().equals(id)) {
                result = items2[i];
                break;
            }
        }
        return result;
    }

    protected String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
}
