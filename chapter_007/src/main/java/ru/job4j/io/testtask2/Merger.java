package ru.job4j.io.testtask2;

import java.util.*;
import java.util.stream.Collectors;

public class Merger {
//    public Map<User, List<String>> start(List<User> users) {
//        Map<User, List<String>> result = new HashMap<>();
//        for (int i = 0; i < users.size() - 1; i++) {
//            List<String> listEmailsFinal = new ArrayList<>();
//            if (checkEmail(users.get(i), users.get(i + 1))) {
//                Set<String> listEmails = merge(users.get(i), users.get(i + 1));
//                for (String s : listEmails) {
//                    listEmailsFinal.add(s);
//                }
//            }
//            result.put(users.get(i), listEmailsFinal);
//        }
//        return result;
//    }

    public Map<User, List<String>> start2(Map<User, List<String>> map) {
        Map<String, User> map1 = new HashMap<>();
        for (User user : map.keySet()) {
            for (String email : map.get(user)) {
                map1.put(email, user);
            }
        }
        Map<User, List<String>> map2 = map1.keySet().stream()
                .distinct().collect(Collectors.groupingBy(map1::get, Collectors.toList()));
        return map2;
    }

    //метод для проверки совпадения email-ов
//    public boolean checkEmail(User user1, User user2) {
//        boolean result = false;
//        for (int i = 0; i < user1.getEmail().size(); i++) {
//            for (int j = 0; j < user2.getEmail().size(); j++) {
//                if (user1.getEmail().get(i).equals(user2.getEmail().get(j))) {
//                    result = true;
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    //метод для слияния email-ов у одинаковых пользователей
//    public Set<String> merge(User user1, User user2) {
//        Set<String> list = new HashSet<>();
//        for (String email1 : user1.getEmail()) {
//            list.add(email1);
//        }
//        for (String email2 : user2.getEmail()) {
//            list.add(email2);
//        }
//        return list;
//    }
}

