package com.example.learnandroid.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.learnandroid.dao.BookDao;
import com.example.learnandroid.enity.BookInfo;

@Database(entities = {BookInfo.class},version = 1,exportSchema = true)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDao bookDao();
}
