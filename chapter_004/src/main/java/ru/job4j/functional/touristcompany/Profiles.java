package ru.job4j.functional.touristcompany;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(n -> n.getAddress())
                .distinct()
                .sorted(Comparator.comparing(n -> n.getCity()))
                .collect(Collectors.toList());
    }
}
