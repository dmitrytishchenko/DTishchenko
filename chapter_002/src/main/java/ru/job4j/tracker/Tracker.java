package ru.job4j.tracker;

        import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RANDOM = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    public boolean replace(String id, Item item) {
        boolean repl = false;
        for (int i = 0; i != this.position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(items[i].getId());
                items[i] = item;
                repl = true;
                break;
            }
        }
        return repl;
    }

    public boolean delete(String id) {
        boolean del = false;
        for (int i = 0; i < this.position; i++) {
            if (id != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position);
                this.position--;
                del = true;
                break;
            }
        }
        return del;
    }
    public Item[] findAll() {
        Item[] items = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            items[i] = this.items[i];
        }
        return items;
    }
    public Item[] findByName(String key) {
        int index = 0;
        Item[] i = new Item[this.position];
        for (Item temp: this.items) {
            if (temp != null && key.equals(temp.getName())) {
                i [index++] = temp;
            }
        }
        return Arrays.copyOf(i, index);
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

}
