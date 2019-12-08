package ru.job4j.odd.dip;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality implements ExtractList, ResortCheck, Verify, Check {
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
        check(food, shop, trash, warehouse);
    }

    @Override
    public void resort() {
        extract(shop.getShopList());
        extract(trash.getTrashList());
        extract(warehouse.getWarehouseList());
        for (Food food : this.list) {
            executeCheck(food);
        }
        System.out.println(shop.getShopList().size());
        System.out.println(trash.getTrashList().size());
        System.out.println(warehouse.getWarehouseList().size());
    }

    @Override
    public List<Food> extract(List<Food> list) {
        for (Food food : list) {
            this.list.add(food);
        }
        list.clear();
        return this.list;
    }

    @Override
    public void check(Food food, Shop shop, Trash trash, Warehouse warehouse) {
        long life = food.getLife();
        long now = food.getNow();
        if (life * 0.25 < now && now < life * 0.75) {
            shop.getShopList().add(food);
        } else if (now > life * 0.75 && now < life) {
            food.setDisscount(50);
            shop.getShopList().add(food);
        } else if (life < now) {
            trash.getTrashList().add(food);
        } else if (life * 0.25 > now) {
            warehouse.getWarehouseList().add(food);
        }
    }
}
