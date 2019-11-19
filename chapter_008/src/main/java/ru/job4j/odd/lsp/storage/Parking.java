package ru.job4j.odd.lsp.storage;

public class Parking {
    private int sizeCar;
    private int sizeTrack;
    private Car[] placeCars = new Car[sizeCar];
    private Track[] placeTrack = new Track[sizeTrack];

    public Parking(int sizeCar, int sizeTrack) {
        this.sizeCar = sizeCar;
        this.sizeTrack = sizeTrack;
    }
}
