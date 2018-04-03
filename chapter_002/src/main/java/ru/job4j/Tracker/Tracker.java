package ru.job4j.Tracker;
import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random rand = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public Item replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            Item temp = items[i];
            if (id.equals(temp.getId())) {
                items[i] = item;
            }
        }
        return item;
    }

    public void delete(String id) {
        for (int i = 0;i< items.length; i++ ) {
            Item temp = items[i];
            if (temp != null && id.equals(temp.getId())) {
                System.arraycopy(items,i,items,i,position);
                break;
            }
        }
    }

    public Item[] findAll() {
        Item[] items = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            items[i] = this.items[i];
        }
        return items;
    }

    public Item[] findByName(String key) {
        Item[] result = null;
        for (Item temp:this.items) {
            if ( temp != null && key.equals(temp.getName())) {
                result = items;
            }
        }
        return result;
    }
    public Item[] findByName2(String key){
        int index = 0;
      Item [] i = new Item[this.position];
      for(Item temp: this.items){
          if(temp != null && key.equals(temp.getName())){
              i [index] = temp;
              index ++;
              System.arraycopy(this.items,0,i,0,position);
          }
      }
        return i;
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
        return String.valueOf(System.currentTimeMillis() + rand.nextInt());
    }

}
