package com.example.unittestdemo.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ShoppingItem")
public class ShoppingItem {

    @PrimaryKey(autoGenerate = true)
    int id;
    String itemName;
    long count;
    long price;

    public ShoppingItem() {
    }

    public ShoppingItem(int id, String itemName, long count, long price) {
        this.id = id;
        this.itemName = itemName;
        this.count = count;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isEmpty(){
        return itemName.isEmpty() || count==0 || price == 0;
    }

    public boolean isEqual(ShoppingItem shoppingItem){
        return itemName.equals(shoppingItem.itemName) &&
                price == shoppingItem.getPrice() &&
                count == shoppingItem.getCount();
    }
}
