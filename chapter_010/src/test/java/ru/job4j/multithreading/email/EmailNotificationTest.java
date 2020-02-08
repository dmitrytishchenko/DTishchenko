package ru.job4j.multithreading.email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificationTest {
@Test
    public void test() {
    EmailNotification emailNotification = new EmailNotification();
    User user1 = new User("Bob", "123@mail.com");
    User user2 = new User("Mark", "321@mail.com");
    User user3 = new User("Leo", "456@mail.com");
    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    users.add(user3);
    for (User u : users) {
        emailNotification.emailTo(u);
    }
    emailNotification.close();
}
}