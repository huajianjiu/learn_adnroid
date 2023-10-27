package com.example.learnandroid.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.learnandroid.enity.GoodsInfo;

import java.util.List;

@Dao
public interface GoodsDao {
    @Insert()
    void insert(GoodsInfo goodsInfos);
    @Query("SELECT * FROM GoodsInfo ORDER BY id DESC")
    List<GoodsInfo> queryAll();
}
