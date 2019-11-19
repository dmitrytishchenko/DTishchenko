package ru.job4j.odd.lsp.storage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HandlerTest {

    @Test
    public void whenParkCarsAndTraks() {
        Handler handler = new Handler();
        Parking parking = new Parking(10, 2);
        Car car1 = new Bmv();
        Track track1 = new Ford();
        parking.addCar(car1);
        parking.addCar(car1);
        parking.addCar(car1);
        parking.addTrack(track1, car1);
        parking.addTrack(track1, car1);
        parking.addTrack(track1, car1);
        assertThat(parking.getCountCars(), is(8));
    }

    @Test
    public void whenParkCarsAndTraks2() {
        Handler handler = new Handler();
        Parking parking = new Parking(10, 2);
        Car car1 = new Bmv();
        Track track1 = new Ford();
        parking.addCar(car1);
        parking.addCar(car1);
        parking.addCar(car1);
        parking.addTrack(track1, car1);
        parking.addTrack(track1, car1);
        parking.addTrack(track1, car1);
        assertThat(parking.getCountTraks(), is(3));
    }
}

