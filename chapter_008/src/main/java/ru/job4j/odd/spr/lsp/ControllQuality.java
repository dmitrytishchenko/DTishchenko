package ru.job4j.odd.spr.lsp;

public class ControllQuality {
    private Check check;

    public ControllQuality(Check check) {
        this.check = check;
    }

    public void executeCheck(Food food) {
        check.check(food);
    }
}
