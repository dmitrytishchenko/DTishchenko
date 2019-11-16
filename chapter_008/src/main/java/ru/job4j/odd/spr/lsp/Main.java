package ru.job4j.odd.spr.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Check check = new Warehouse();
        ControllQuality controllQuality1 = new ControllQuality(check);
        controllQuality1.executeCheck(
                new Food("Milk", new SimpleDateFormat("dd-M-yyyy").parse("22-11-2019"),
                        new SimpleDateFormat("dd-M-yyyy").parse("1-11-2019"), 100, 0));
        check = new Shop();
        ControllQuality controllQuality2 = new ControllQuality(check);
        controllQuality2.executeCheck(
                new Food("Milk", new SimpleDateFormat("dd-M-yyyy").parse("22-11-2019"),
                        new SimpleDateFormat("dd-M-yyyy").parse("1-11-2019"), 100, 0));
        check = new Trash();
        ControllQuality controllQuality3 = new ControllQuality(check);
        controllQuality3.executeCheck(
                new Food("Milk", new SimpleDateFormat("dd-M-yyyy").parse("22-11-2019"),
                        new SimpleDateFormat("dd-M-yyyy").parse("1-11-2019"), 100, 0));
    }
}
