package ru.job4j.servlets.crud;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserServletTest {
    Dispatcher dispatcher = new Dispatcher();
    User user1 = new User(1, "Mike");
    User user2 = new User(2, "Nike");
    User user3 = new User(3,"Like");

    @Test
    public void testAddAndUpdateUsers() {
        dispatcher.createNewUser(user1);
        dispatcher.createNewUser(user2);
        dispatcher.createNewUser(user3);
        User user4 = new User(2,"Demon");
        dispatcher.update(user4);
        assertThat(dispatcher.findById(2).getName(), is("Demon"));
    }
    @Test
    public void testAddAndDeleteUsers() {
        dispatcher.createNewUser(user1);
        dispatcher.createNewUser(user2);
        dispatcher.createNewUser(user3);
        dispatcher.delete(user2);
        assertThat(dispatcher.findAll().size(), is(2));
    }

}