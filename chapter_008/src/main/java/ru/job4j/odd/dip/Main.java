package ru.job4j.odd.dip;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Food food = new Food("Milk", new SimpleDateFormat("dd-M-yyyy").parse("15-12-2019"),
                        new SimpleDateFormat("dd-M-yyyy").parse("1-11-2019"), 100, 0);
        ControllQuality controllQuality = new ControllQuality(new Shop(), new Trash(), new Warehouse());
        controllQuality.executeCheck(food);
        controllQuality.resort();
    }
}
