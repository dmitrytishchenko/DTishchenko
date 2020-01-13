package ru.job4j.multithreading.storage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    private class ThreadStorage extends Thread {
        private final UserStorage userStorage;

        private ThreadStorage(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            userStorage.transfer(1, 2, 50);
        }
    }

    @Test
    public void whenAddTwoUsersAndTransferAmount() throws InterruptedException {
        final UserStorage storage = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        storage.add(user1);
        storage.add(user2);
        ThreadStorage thread1 = new ThreadStorage(storage);
        ThreadStorage thread2 = new ThreadStorage(storage);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(user2.getAmount(), is(300));
    }

}