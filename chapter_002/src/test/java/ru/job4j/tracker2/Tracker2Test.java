package ru.job4j.tracker2;

import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Tracker2Test {
    @Test
    public void add2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("id", "name", "desc");
        Item result = tracker2.add2(item);
        assertThat(result, is(item));
    }
    @Test
    public void replace2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        Item item2 = new Item("name2", "desc2");
        tracker2.add2(item);
        Boolean result = tracker2.replace2(item.getId(), item2);
        assertThat(result, is(true));
    }
    @Test
    public void findById2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Item result = tracker2.findById2(item.getId());
        assertThat(result, is(item));
    }
    @Test
    public void findByName2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Item result = tracker2.findByName2("name");
        assertThat(result, is(item));
    }
    @Test
    public void findAll2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        tracker2.add2(item);
        tracker2.add2(item2);
        tracker2.add2(item3);
        tracker2.findAll2();
        assertThat(tracker2.getPosition(), is(3));
    }

    @Test
    public void delete2() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Boolean result = tracker2.delete2(item.getId());
        assertThat(result, is(true));
    }
}