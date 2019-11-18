package ru.job4j.odd.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Check {
    private List<Food> shopList = new ArrayList<>();

    @Override
    public void check(Food food) {

        long life = food.getLife();
        long now = food.getNow();
        if (life * 0.25 < now && now < life * 0.75) {
            shopList.add(food);
        } else if (now > life * 0.75 && now < life) {
            food.setDisscount(50);
            shopList.add(food);
        }
        System.out.println(shopList.size());
    }
}
