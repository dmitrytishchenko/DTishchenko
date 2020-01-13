package ru.job4j.multithreading.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    List<User> store = new ArrayList<>();

    public synchronized boolean add(User user) {
        return this.store.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        for (User u : this.store) {
            if (u.getId() == user.getId()) {
                u.setAmount(user.getAmount());
                result = true;
            }
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        for (User u : this.store) {
            if (user.equals(u)) {
                result = this.store.remove(u);
            }
        }
        return result;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        for (User user : this.store) {
            if (user.getId() == fromId) {
                user.setAmount(user.getAmount() - amount);
            } else if (user.getId() == toId) {
                user.setAmount(user.getAmount() + amount);
            }
        }
    }
}
