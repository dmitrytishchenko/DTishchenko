package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserConvertTest {
    @Test
    public void convertListToHashMap() {

        User user1 = new User("Bob", 12, "Moscow");
        User user2 = new User("Vasia", 3, "New York");
        User user3 = new User("Ben", 1, "Saratov");

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        HashMap<Integer, User> result = new HashMap<Integer, User>();
        result.put(user1.getId(), user1);
        result.put(user2.getId(), user2);
        result.put(user3.getId(), user3);

        UserConvert convert = new UserConvert();
        Map<Integer, User> expect = convert.process(users);
        assertThat(result, is(expect));
    }

}