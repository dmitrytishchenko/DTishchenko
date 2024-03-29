package ru.job4j.functional.touristcompany;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenGetAddress() {
        Profile profile1 = new Profile(new Address("Moscow", "Mira", 15, 23));
        Profile profile2 = new Profile(new Address("Kirov", "Lenina", 11, 88));
        Profile profile3 = new Profile(new Address("Rostov", "Zoi Kosmodemianskoi", 9, 43));
        Profile profile4 = new Profile(new Address("Rostov", "Zoi Kosmodemianskoi", 9, 43));
        List<Profile> list = Arrays.asList(profile1, profile2, profile3, profile4);
        List<Address> expected = Arrays.asList(profile2.getAddress(), profile1.getAddress(), profile3.getAddress());
        List<Address> result = Profiles.collect(list);
        assertThat(result, is(expected));
    }

}