package com.example.learnandroid.enity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CartInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int goods_id;

    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", count=" + count +
                '}';
    }
}
