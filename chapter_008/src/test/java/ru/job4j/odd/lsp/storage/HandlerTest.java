package ru.job4j.odd.lsp.storage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HandlerTest {

    @Test
    public void whenParkCarsAndTraks() {
        Handler handler = new Handler();
        Parking parking = new Parking(10, 2);
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        assertThat(parking.getCountCars(), is(8));
    }

    @Test
    public void whenParkCarsAndTraks2() {
        Handler handler = new Handler();
        Parking parking = new Parking(10, 2);
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        assertThat(parking.getCountTraks(), is(3));
    }

    @Test
    public void whenCarsCanNotPark() {
        Parking parking = new Parking(10, 2);
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        parking.addCar(new Car("BMV", 1));
        assertThat(parking.getSizeCar(), is(0));
    }

    @Test
    public void whenTracksCanNotPark() {
        Parking parking = new Parking(10, 2);
        parking.addTrack(new Track("Ford", 5), new Car("BMV", 1));
        assertThat(parking.getSizeTrack(), is(0));
    }

    @Test
    public void whenCarNotPark() {
        Parking parking = new Parking(10, 2);
        boolean result = parking.park(new Car("BMV", 1));
        assertThat(result, is(false));
    }

    @Test
    public void whenTrackNotPark() {
        Parking parking = new Parking(10, 2);
        boolean result = parking.park(new Track("Ford", 5));
        assertThat(result, is(false));
    }
}

