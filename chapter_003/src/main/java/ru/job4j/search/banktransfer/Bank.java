package ru.job4j.search.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    /*
    * Коллекция Map с ключем User, значением - List<Account> - список счетов каждого пользователя
    */
    Map<User, List<Account>> users = new HashMap<>();

    /*
    * Метод addUser - добавление нового пользователя
    * @param - user - пользователь
    */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /*
    * Метод deleteUser - удаление пользователя
    * @param - user - пользователь
    */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /*
    * Метод addAccountToUser - добавление нового счета для определенного пользователя
    * @param - passport - паспорт пользователя
    * @param - account - новый счет пользователя
    */
    public void addAccountToUser(String passport, Account account) {
        for (User value : this.users.keySet()) {
            if (value.getPassport().equals(passport)) {
                this.users.get(value).add(account);
            }
        }
    }

    /*
    * Метод deleteAccountFromUser - удаления счета для определенного пользователя
    * @param - passport - паспорт пользователя
    * @param - account - счет пользователя
    */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User value : this.users.keySet()) {
            if (value.getPassport().equals(passport)) {
                this.users.get(value).remove(account);
            }
        }
    }

    /*
    * Метод getUserAccount - получить список счетов для пользователя
    * @param - passport - паспорт пользователя
    */
    public List<Account> getUserAccount(String passport) {
        List<Account> list = new ArrayList<>();
        for (User value : this.users.keySet()) {
            if (value.getPassport().equals(passport)) {
                list = this.users.get(value);
            }
        }
        return list;
    }

    /*
    * Метод transferMoney -  для перечисления с одного счета на другой счет,
    * если если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    * @param - srcPassport - паспорт пользователя отправителя
    * @param - srcRequisite - реквизиты счета отправителя
    * @param - destPassport - паспорт пользователя получателя
    * @param - destRequisite - реквизиты счета получателя
    * @param - amount - сумма денег.
    * */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        if (amount <= 0) {
            return false;
        }
        for (int i = 0; i < users.size() - 1; i++) {
            Account srcAccount = this.getUserAccount(srcPassport).get(i);
            Account destAccount = this.getUserAccount(destPassport).get(i);
            if (Integer.parseInt(srcRequisite) == srcAccount.getRequisites() && Integer.parseInt(destRequisite) == destAccount.getRequisites()) {
                srcAccount.setValue(srcAccount.getValue() - (int) amount);
                destAccount.setValue(destAccount.getValue() + (int) amount);
                result = true;
            }
        }
        return result;
    }

    /*
    * Метод getUserAccount2 - для поиска акаунта пользователя по реквизитам и паспорту
    * @param - passport - паспорт пользователя
    * @param - requisite - реквизиты пользователя
    * return - список пользователей
    */
    public List<Account> getUserAccount2(String passport, long requisite) {
        List<Account> list = new ArrayList<>();
        for (User value : this.users.keySet()) {
            if (value.getPassport().equals(passport)) {
                for (Account ac : this.users.get(requisite)) {
                    if (ac.getRequisites() == requisite) {
                        list = this.users.get(value);
                    }
                }
            }

        }
        return list;
    }
}
