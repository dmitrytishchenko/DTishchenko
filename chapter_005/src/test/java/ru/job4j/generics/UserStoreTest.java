package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    User user1 = new User("user1");
    User user2 = new User("user2");
    User user3 = new User("user3");
    @Test
    public void whenAddUserToStore() {
        UserStore userStore = new UserStore(3);
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.findById("user1"), is(user1));
    }
    @Test
    public void whenReplaceUserInStore() {
        UserStore userStore = new UserStore(3);
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        boolean result = userStore.replace("user1", user3);
        assertThat(result, is(true));
    }
    @Test
    public void whenDeleteUserFromStore() {
        UserStore userStore = new UserStore(3);
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        boolean result = userStore.delete("user1");
        assertThat(result, is(true));
    }
    @Test
    public void whenFindUserById() {
        UserStore userStore = new UserStore(3);
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        User result = userStore.findById("user1");
        assertThat(result, is(user1));
    }
}