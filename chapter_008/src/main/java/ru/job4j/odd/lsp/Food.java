package ru.job4j.odd.lsp;

import java.util.Date;

public class Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private int price;
    private int disscount;

    public String getName() {
        return name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDisscount() {
        return disscount;
    }

    public Food(String name, Date expaireDate, Date createDate, int price, int disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public long getLife() {
        return getExpaireDate().getTime() - getCreateDate().getTime();
    }

    public long getNow() {
        return new Date().getTime() - getCreateDate().getTime();
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }
}
