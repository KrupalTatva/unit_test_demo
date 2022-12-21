package com.example.unittestdemo.di;

import android.content.Context;

import androidx.room.Room;

import com.example.unittestdemo.DB.MyDatabase;
import com.example.unittestdemo.DB.ShoppingItemDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {


    @Singleton
    @Provides
    public MyDatabase getDatabase(
            @ApplicationContext Context context
    ){
        return Room.databaseBuilder(context,MyDatabase.class , "shopping_item_DB").build();
    }

    @Singleton
    @Provides
    public ShoppingItemDao getShoppingItemDao(
            MyDatabase database
    ){
        return database.getShoppingItemDao();
    }

}
