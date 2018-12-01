package ru.job4j.search.banktransfer;

public class Account {
    private int value;
    private long requisites;

    public Account(int value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public long getRequisites() {
        return requisites;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
