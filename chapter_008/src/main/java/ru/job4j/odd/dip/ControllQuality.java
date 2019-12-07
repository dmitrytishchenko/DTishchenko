package ru.job4j.odd.dip;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality implements ExtractList, ResotrCheck, Verify {
    private List<Food> list = new ArrayList<>();
    private Shop shop;
    private Trash trash;
    private Warehouse warehouse;

    public ControllQuality(Shop shop, Trash trash, Warehouse warehouse) {
        this.shop = shop;
        this.trash = trash;
        this.warehouse = warehouse;
    }

    @Override
    public void executeCheck(Food food) {
        food.check(shop, trash, warehouse);
    }

    @Override
    public void resort() {
        extract(shop.getShopList());
        extract(trash.getTrashList());
        extract(warehouse.getWarehouseList());
        for (Food food : this.list) {
            executeCheck(food);
        }
    }

    @Override
    public List<Food> extract(List<Food> list) {
        for (Food food : list) {
            this.list.add(food);
        }
        list.clear();
        return this.list;
    }
}
