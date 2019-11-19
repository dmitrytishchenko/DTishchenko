package ru.job4j.odd.lsp.storage;

public class Parking {
    private int sizeCar;
    private int sizeTrack;
    private Car[] placeCars;
    private Track[] placeTrack;
    private int countCars = 0;
    private int countTraks = 0;

    public Parking(int sizeCar, int sizeTrack) {
        this.sizeCar = sizeCar;
        this.sizeTrack = sizeTrack;
        this.placeCars = new Car[sizeCar];
        this.placeTrack = new Track[sizeTrack];
    }

    public void addCar(Car car) {
        if (sizeCar > 0) {
            this.placeCars[countCars++] = car;
            this.sizeCar--;
        }
    }

    public void addTrack(Track track, Car car) {
        if (sizeTrack > 0) {
            for (int i = 0; i < placeTrack.length; i++) {
                placeTrack[countTraks++] = track;
                this.sizeTrack--;
            }
        } else if (this.sizeCar >= 5) {
            for (int i = 0; i < 5; i++) {
                this.placeCars[countCars++] = car;
                this.sizeCar--;
            }
            countTraks++;
        } else {
            System.out.println("Парковочных мест больше нет!!!");
        }
    }

    public int getCountCars() {
        return countCars;
    }

    public int getCountTraks() {
        return countTraks;
    }
}
