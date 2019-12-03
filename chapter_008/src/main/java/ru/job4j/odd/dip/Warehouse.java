package ru.job4j.odd.dip;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Check {
    private List<Food> warehouseList = new ArrayList<>();

    @Override
    public void check(Food food) {
        long life = food.getLife();
        long now = food.getNow();
        if (life * 0.25 > now) {
            warehouseList.add(food);
        }
        System.out.println(warehouseList.size());
    }

    public List<Food> getWarehouseList() {
        return warehouseList;
    }
}
