package ru.job4j.multithreading.elevator;

public class Args {
    private String floors;
    private String floorHeight;
    private String speedElevator;
    private String timeOpenDoors;

    //    "f" - floors
    //    "h" - floorHeight
    //    "s" - speedElevator
    //    "t" - timeOpenDoors
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("f")) {
                this.floors = args[++i];
            } else if (args[i].equals("h")) {
                this.floorHeight = args[++i];
            } else if (args[i].equals("s")) {
                this.speedElevator = args[++i];
            } else if (args[i].equals("t")) {
                this.timeOpenDoors = args[++i];
            }
        }
    }

    public String getFloors() {
        return this.floors;
    }

    public String getFloorHeight() {
        return this.floorHeight;
    }

    public String getSpeedElevator() {
        return this.speedElevator;
    }

    public String getTimeOpenDoors() {
        return this.timeOpenDoors;
    }
}
