package ru.job4j.testtask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HotelsTest {

    @Test
    public void whenAddFiveHotels() {
        List<Integer> hotel = new ArrayList<>(Arrays.asList(5, 2, 3, 4, 1));
        Hotels hotels = new Hotels();
        List<Integer> result = hotels.addTheStar(hotel);
        assertThat(result, is(new ArrayList(Arrays.asList(5, 2, 3, 4, 1))));
    }

    @Test
    public void whenAddFive2Hotels() {
        List<Integer> hotel = new ArrayList<>(Arrays.asList(99, 2, 100, 50, 1));
        Hotels hotels = new Hotels();
        List<Integer> result = hotels.addTheStar(hotel);
        assertThat(result, is(new ArrayList(Arrays.asList(4, 2, 5, 3, 1))));
    }

    @Test
    public void whenAddFifteenHotels() {
        List<Integer> hotel = new ArrayList<>(Arrays.asList(100, 90, 10, 20, 50, 60, 40, 30, 80, 70));
        Hotels hotels = new Hotels();
        List<Integer> result = hotels.addTheStar(hotel);
        assertThat(result, is(new ArrayList(Arrays.asList(5, 5, 1, 1, 3, 3, 2, 2, 4, 4))));
    }
}