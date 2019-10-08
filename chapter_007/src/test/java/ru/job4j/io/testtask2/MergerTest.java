package ru.job4j.io.testtask2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergerTest {
    @Test
    public void testMergerStart() {
        Merger merger = new Merger();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        user1.getEmail().add("xxx@ya.ru");
        user1.getEmail().add("foo@gmail.com");
        user1.getEmail().add("lol@mail.ru");
        user2.getEmail().add("foo@gmail.com");
        user2.getEmail().add("ups@pisem.net");
        user3.getEmail().add("xyz@pisem.net");
        user3.getEmail().add("vasya@pupkin.com");
        user4.getEmail().add("ups@pisem.net");
        user4.getEmail().add("aaa@bbb.ru");
        user5.getEmail().add("xyz@pisem.net");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Map<User, List<String>> expected = merger.start(users);
        assertThat(expected.size(), is(2));
    }

}