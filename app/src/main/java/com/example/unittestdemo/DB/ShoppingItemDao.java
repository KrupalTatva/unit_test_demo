package com.example.unittestdemo.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.unittestdemo.model.ShoppingItem;

import java.util.List;

@Dao
public
interface ShoppingItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoppingItem(ShoppingItem shoppingItem);


    @Delete
    void deleteShoppingItem(ShoppingItem shoppingItem);

    @Query("select * from ShoppingItem")
    List<ShoppingItem> getShoppingItem();

    @Query("select SUM(price * count) from ShoppingItem")
    Long getTotalPrice();
}
