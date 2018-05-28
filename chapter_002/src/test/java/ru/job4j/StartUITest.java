package ru.job4j;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
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
}
