package ru.job4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }
    @Test
    public  void whenUserRequestAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{item}));
    }
    @Test
    public void whenUserReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name2"));
    }
    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item value = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0), is(value));
    }
    @Test
    public void whenUserFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).get(0), is(item));
    }
    @Test
    public void whenUserFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        MenuTracker menu = new MenuTracker(input, tracker);
        new StartUI(input, tracker).init();
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenUpdateThenTrackerHasUpdateValue2() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        MenuTracker menu = new MenuTracker(input, tracker);
        Item item = tracker.add(new Item("test name", "desc"));
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    @Test
    public  void whenUserRequestAllItems2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        assertThat(tracker.findAll(), is(new Item[]{item}));
    }
    @Test
    public void whenUserReplaceItem2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenUserFindItemByName2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        assertThat(tracker.findByName(item.getName()).get(0), is(item));
    }
    @Test
    public void whenUserFindItemById2() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
