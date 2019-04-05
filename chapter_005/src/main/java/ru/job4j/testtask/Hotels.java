package ru.job4j.testtask;

import java.util.*;

public class Hotels {
    private List<Integer> hotels;

    public Hotels(List<Integer> hotels) {
        this.hotels = hotels;
    }

    public List<Integer> addTheStar(List<Integer> hotels) {
        List<Integer> rating = new ArrayList<>();
        for (int i = 0; i < hotels.size(); i++) {
            rating.add(hotels.get(i));
        }

        int maximum = rating.get(rating.size() - 1);
        int minimum = rating.get(0);
        Map<Integer, Integer> map = new LinkedHashMap<>();


        for (int i = 0; i < rating.size(); i++) {
            if (i == minimum) {
                map.put(i, 1);
            } else if (i == maximum) {
                map.put(i, 5);
            } else  if (minimum < i && i < rating.size() / 2) {
                map.put(i, 2);
            } else if (i > rating.size() / 2 && i < maximum) {
                map.put(i, 4);
            } else {
                map.put(i, 3);
            }
        }
        List<Integer> stars = new ArrayList<>();
        for (Integer value : map.values()) {
            stars.add(value);
        }
        return stars;
    }

    public static void main(String[] args) {

        List<Integer> hot = new ArrayList<>();
        hot.add(1);
        hot.add(2);
        hot.add(3);
        hot.add(4);
        hot.add(5);
        Hotels hotels = new Hotels(hot);
        List<Integer> result = hotels.addTheStar(hot);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
