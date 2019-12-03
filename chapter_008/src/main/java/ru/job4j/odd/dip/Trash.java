package ru.job4j.odd.dip;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Check {
    private List<Food> trashList = new ArrayList<>();

    @Override
    public void check(Food food) {
        long life = food.getLife();
        long now = food.getNow();
        if (life < now) {
            trashList.add(food);
        }
        System.out.println(trashList.size());
    }

    public List<Food> getTrashList() {
        return trashList;
    }
}
