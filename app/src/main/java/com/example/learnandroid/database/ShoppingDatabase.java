package com.example.learnandroid.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.learnandroid.dao.CartDao;
import com.example.learnandroid.dao.GoodsDao;
import com.example.learnandroid.enity.CartInfo;
import com.example.learnandroid.enity.GoodsInfo;

@Database(entities = {GoodsInfo.class, CartInfo.class},version = 1,exportSchema = true)
public abstract class ShoppingDatabase extends RoomDatabase {
    public abstract GoodsDao goodsDao();
    public abstract CartDao cartDao();
}
