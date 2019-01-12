package ru.job4j.search.banktransfer;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    /*
    * Коллекция Map с ключем User, значением - List<Account> - список счетов каждого пользователя
    */
    protected Map<User, List<Account>> users = new HashMap<>();

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
        this.users.keySet().stream()
                .filter(n -> n.getPassport().equals(passport))
                .forEach(n -> this.users.get(n).add(account));
//               for (User value : this.users.keySet()) {
//            if (value.getPassport().equals(passport)) {
//                this.users.get(value).add(account);
    }
    /*
    * Метод deleteAccountFromUser - удаления счета для определенного пользователя
    * @param - passport - паспорт пользователя
    * @param - account - счет пользователя
    */
    public void deleteAccountFromUser(String passport, Account account) {
        this.users.keySet().stream()
                .filter(n -> n.getPassport().equals(passport))
                .forEach(n -> this.users.get(n).remove(account));
//        for (User value : this.users.keySet()) {
//            if (value.getPassport().equals(passport)) {
//                this.users.get(value).remove(account);
//            }
//        }
    }

    /*
    * Метод getUserAccount - получить список счетов для пользователя
    * @param - passport - паспорт пользователя
    */
    public List<Account> getUserAccount(String passport) {
        List<Account> list = this.users.keySet().stream()
                .filter(n -> n.getPassport().equals(passport))
                .flatMap(n -> this.users.get(n).stream())
                .collect(Collectors.toList());
//        List<Account> list = null;
//        for (User value : this.users.keySet()) {
//            if (value.getPassport().equals(passport)) {
//                list = this.users.get(value);
//            }
//        }
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
        Account srcAccount = this.getUserAccount2(srcPassport, srcRequisite);
        Account destAccount = this.getUserAccount2(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getValue() >= amount) {
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

    public Account getUserAccount2(String passport, String requisite) {
        Account account = null;
        List<Account> accounts = this.getUserAccount(passport);
        account = accounts.stream()
                .filter(n -> n.getRequisites().equals(requisite))
                .filter(Objects:: nonNull).findFirst().get();
//        Account account = null;
//        List<Account> list = getUserAccount(passport);
//        if (list != null) {
//            for (Account ac : list) {
//                if (requisite.equals(ac.getRequisites())) {
//                    account = ac;
//                    break;
//                }
//            }
//        }
        return account;
    }
}
