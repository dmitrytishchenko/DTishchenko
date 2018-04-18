package ru.job4j;


import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription1", 123L, "first item");
        Item result = tracker.add(item);
        assertThat(result, is(item));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription2", 124L, "second item");
        Item result = tracker.replace("12345", item);
        assertThat(result, is(item));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3", "testDescrition3", 125L, "third item");
        Item result = tracker.replace("12346", item);
        assertThat(result, is(item));
    }

    @Test
    public void delete(){
        Tracker tracker = new Tracker();
        Item item = new Item("test4", "testDescription4", 126L, "fourth item");
        tracker.delete("12347");
        assertThat("12347", is("12347"));
    }

    @Test
    public void findall(){
        Tracker tracker = new Tracker();
        Item item = new Item("test5", "testDescription5", 127L, "fifth item");
        tracker.add(item);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[] {item}));
        }

    @Test
    public void findByName(){
        Tracker tracker = new Tracker();
        Item item = new Item("test6", "testDescription6", 128L, "sixth item");
        tracker.add(item);
        Item [] result = tracker.findByName("test6");
        assertThat(result [0], is(item));

    }
    @Test
    public void findByName2(){
        Tracker tracker = new Tracker();
        Item item = new Item("test7", "testDescription7", 129L, "seventh item");
        tracker.add(item);
        Item [] result = tracker.findByName2("test7");
        assertThat(result, is(new Item[]{item}));
    }
    @Test
    public void delete2(){
        int [] temp = {1,2,3,4,5};
        System.arraycopy(temp, 2,temp, 1, 3);
        System.out.println(Arrays.toString(temp));
    }
}