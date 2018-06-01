package ru.job4j;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemhenTrackerHasNewItemWithSameName(){
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdateValue(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
//        Создаем StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1",item.getId(),"test name", "desc", "6"});
//        Создаем StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
//        проверяем, что нулевой элемент массива в трекере содержит имя, введенное при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    @Test
    public  void whenUserRequestAllItems(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1","test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{item}));
    }
    @Test
    public void whenUserReplaceItem(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2","12345", "test name", "desc","comments", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.replace("12345", item), is(item));
    }
    @Test
    public void whenUserDeleteItem(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item value = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(value));
    }
    @Test
    public void whenUserFindItemByName(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0], is(item));
    }
    @Test
    public void whenUserFindItemById(){
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getId(), "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
