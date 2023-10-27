package com.example.learnandroid.enity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String writer;
    private String press;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", press='" + press + '\'' +
                ", price=" + price +
                '}';
    }
}
