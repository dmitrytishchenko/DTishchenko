package ru.job4j.tracker2;

import org.junit.Test;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUI2Test {
    @Test
    public void whenUserAddNewItem() {
        Tracker2 tracker2 = new Tracker2();
        Input input = new StubInput(new String[]{"0", "item", "desc", "6"});
        new StartUI2(input, tracker2).init();
        assertThat(tracker2.findAll2()[0].getName(), is("item"));
    }

    @Test
    public void whenUserEditItem() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "name2", "desc2", "6"});
        new StartUI2(input, tracker2).init();
        assertThat(tracker2.findAll2()[0].getName(), is("name2"));
    }

    @Test
    public void whenUserDeleteItem() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        Item item2 = new Item("name2", "desc2");
        tracker2.add2(item);
        tracker2.add2(item2);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI2(input, tracker2).init();
        assertThat(tracker2.findAll2()[0].getName(), is("name2"));
    }

    @Test
    public void whenUserFindItemById() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI2(input, tracker2).init();
        assertThat(tracker2.findById2(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenUserFindItemByName() {
        Tracker2 tracker2 = new Tracker2();
        Item item = new Item("name", "desc");
        tracker2.add2(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI2(input, tracker2).init();
        assertThat(tracker2.findByName2(item.getName()).getName(), is(item.getName()));
    }
}