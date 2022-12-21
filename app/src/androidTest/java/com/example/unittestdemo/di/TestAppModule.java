package com.example.unittestdemo.di;

import android.content.Context;

import androidx.room.Room;

import com.example.unittestdemo.DB.MyDatabase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class TestAppModule {

    @Provides
    @Named("test_db")
    public MyDatabase getTEstDatabase(
            @ApplicationContext Context context
            ){
        return Room.inMemoryDatabaseBuilder(context , MyDatabase.class).allowMainThreadQueries().build();
    }
}
