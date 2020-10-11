package com.example.activity.activityintent;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String idsn;
    private String name;
    private float price;

    public Book(int id, String idsn, String name, float price) {
        this.id = id;
        this.idsn = idsn;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", idsn='" + idsn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdsn() {
        return idsn;
    }

    public void setIdsn(String idsn) {
        this.idsn = idsn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
