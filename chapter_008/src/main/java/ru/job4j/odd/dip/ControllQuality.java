package ru.job4j.odd.dip;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality implements ExtractList {
    private Check check;
    private List<Food> list = new ArrayList<>();

    public ControllQuality(Check check) {
        this.check = check;
    }

    public ControllQuality() {
    }

    public void executeCheck(Food food) {
        check.check(food);
    }

    public void resort() {
        extract(new Shop().getShopList());
        extract(new Trash().getTrashList());
        extract(new Warehouse().getWarehouseList());
        for (Food food : list) {
            check.check(food);
        }
    }
    @Override
    public List<Food> extract(List<Food> list) {
        for (Food food : list) {
            this.list.add(food);
        }
        return list;
    }

    public List<Food> getList() {
        return list;
    }
}
