package ru.job4j.io.testtask2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergerTest {
//    @Test
//    public void testMergerStart() {
//        Merger merger = new Merger();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        user1.getEmail().add("xxx@ya.ru");
//        user1.getEmail().add("foo@gmail.com");
//        user1.getEmail().add("lol@mail.ru");
//
//        user2.getEmail().add("foo@gmail.com");
//        user2.getEmail().add("ups@pisem.net");
//
//        user3.getEmail().add("xyz@pisem.net");
//        user3.getEmail().add("vasya@pupkin.com");
//
//        user4.getEmail().add("ups@pisem.net");
//        user4.getEmail().add("aaa@bbb.ru");
//
//        user5.getEmail().add("xyz@pisem.net");
//        List<User> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        users.add(user5);
//        Map<User, List<String>> expected = merger.start(users);
//        System.out.println(expected.size());
//        assertThat(expected.size(), is(2));
//    }
    @Test
    public void testMergerStart2() {
        Merger merger = new Merger();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        list1.add("xxx@ya.ru");
        list1.add("foo@gmail.com");
        list1.add("lol@mail.ru");
        list2.add("foo@gmail.com");
        list2.add("ups@pisem.net");
        list3.add("xyz@pisem.net");
        list3.add("vasya@pupkin.com");
        list4.add("ups@pisem.net");
        list4.add("aaa@bbb.ru");
        list5.add("xyz@pisem.net");
        Map<User, List<String>> map = new HashMap<>();
        map.put(user1, list1);
        map.put(user2, list2);
        map.put(user3, list3);
        map.put(user4, list4);
        map.put(user5, list5);
        Map<User, List<String>> expected = merger.start2(map);
        System.out.printf(expected.entrySet().toString());
        assertThat(expected.size(), is(3));
    }
}