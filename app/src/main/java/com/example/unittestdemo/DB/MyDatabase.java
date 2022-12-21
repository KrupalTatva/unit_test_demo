package com.example.unittestdemo.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.unittestdemo.model.ShoppingItem;

@Database(
        entities = {ShoppingItem.class},
        version = 1
)

public abstract class MyDatabase extends RoomDatabase {

    public abstract ShoppingItemDao getShoppingItemDao();

}
