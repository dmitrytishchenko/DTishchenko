package ru.job4j.search.banktransfer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void addUser() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        assertThat(bank.users.containsKey(user), is(true));
    }

    @Test
    public void deleteUser() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.users.containsKey(user), is(false));
    }

    @Test
    public void addAccountToUser() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        Account account = new Account(100, "101105");
        bank.addAccountToUser("12345", account);
        assertThat(bank.getUserAccount("12345").size(), is(1));
    }

    @Test
    public void deleteAccountFromUser() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        Account account = new Account(100, "101105");
        bank.deleteAccountFromUser("12345", account);
        assertThat(bank.getUserAccount("12345").size(), is(0));
    }

    @Test
    public void getUserAccount() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        Account account = new Account(100, "101105");
        bank.addAccountToUser("12345", account);
        bank.getUserAccount("12345");
        assertThat(bank.getUserAccount("12345").size(), is(1));
    }

    @Test
    public void transferMoney() throws Exception {
        Bank bank = new Bank();
        User user1 = new User("Peyia", "12345");
        User user2 = new User("Vasia", "54321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(100, "101501");
        Account account2 = new Account(10, "101502");
        bank.addAccountToUser("12345", account1);
        bank.addAccountToUser("54321", account2);
        boolean result = bank.transferMoney("12345", "101501", "54321", "101502", 5);
        assertThat(result, is(true));
    }

    @Test
    public void getUserAccount2() throws Exception {
        Bank bank = new Bank();
        User user = new User("Peyia", "12345");
        bank.addUser(user);
        Account account = new Account(100, "101105");
        bank.addAccountToUser("12345", account);
        bank.getUserAccount2("12345", "101105");
        assertThat(bank.getUserAccount2("12345", "101105"), is(account));
    }
}