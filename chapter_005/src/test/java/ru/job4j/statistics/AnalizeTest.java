package ru.job4j.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    List<Analize.User> previous = new ArrayList<>();
    List<Analize.User> current = new ArrayList<>();
    Analize.User user = new Analize.User(1, "Petia");
    Analize.User user2 = new Analize.User(2, "Vasia");
    Analize.User user3 = new Analize.User(3, "Vania");
    Analize.User user4 = new Analize.User(4, "Ben");

    @Test
    public void whenAddOneDelTwo() {
        previous.add(user);
        previous.add(user2);
        previous.add(user3);
        current.add(user3);
        current.add(user4);
        Analize store = new Analize();
        assertThat(store.diff(previous, current), is(new Analize.Info(1, 0, 2)));
    }

    @Test
    public void whenAddTwoChangedTwoDeleteNull() {
        previous.add(user);
        previous.add(user2);
        current.add(new Analize.User(1, "Vasia"));
        current.add(new Analize.User(2, "Petia"));
        current.add(user3);
        current.add(user4);
        Analize store = new Analize();
        assertThat(store.diff(previous, current), is(new Analize.Info(4, 2, 2)));
    }
}