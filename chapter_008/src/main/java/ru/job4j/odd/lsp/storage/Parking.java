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

    public boolean park(Car car) {
        boolean result = false;
        if (sizeCar > 0) {
            this.placeCars[countCars++] = car;
            this.sizeCar--;
            result = true;
        } else {
            System.out.println("Парковочных мест для легковых автомобилей больше нет.");
        }
        return result;
    }

    public boolean park(Track track, Car car) {
        boolean result = false;
        if (sizeTrack > 0) {
            for (int i = 0; i < placeTrack.length; i++) {
                placeTrack[countTraks++] = track;
                this.sizeTrack--;
                result = true;
                break;
            }
        } else if (this.sizeCar >= 5) {
            for (int i = 0; i < 5; i++) {
                this.placeCars[countCars++] = car;
                this.sizeCar--;
            }
            countTraks++;
            result = true;
        } else {
            System.out.println("Парковочных мест для грузовых автомобилей больше нет!!!");
        }
        return result;
    }

    public int getCountCars() {
        return countCars;
    }

    public int getCountTraks() {
        return countTraks;
    }

    public int getSizeCar() {
        return sizeCar;
    }

    public int getSizeTrack() {
        return sizeTrack;
    }
}
