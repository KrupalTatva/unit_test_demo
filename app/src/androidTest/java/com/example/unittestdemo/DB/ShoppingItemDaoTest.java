package com.example.unittestdemo.DB;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.unittestdemo.model.ShoppingItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.function.Predicate;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

@SmallTest
@HiltAndroidTest
public class ShoppingItemDaoTest {

    @Rule
    public HiltAndroidRule hiltAndroidRule = new HiltAndroidRule(this);


    @Inject
    @Named("test_db")
    MyDatabase myDatabase;
    ShoppingItemDao shoppingItemDao;

    @Before
    public void setUp() throws Exception {
//        myDatabase = Room.inMemoryDatabaseBuilder(
//                ApplicationProvider.getApplicationContext(),
//                MyDatabase.class
//        )
//                .allowMainThreadQueries()
//                .build();
        hiltAndroidRule.inject();
        shoppingItemDao = myDatabase.getShoppingItemDao();
    }

    @After
    public void tearDown() throws Exception {
        myDatabase.close();
    }

    @Test
    public void insertItemTrue(){
        ShoppingItem shoppingItem = new ShoppingItem(0,"item1",1L,5L);
        shoppingItemDao.insertShoppingItem(shoppingItem);

        List<ShoppingItem> result = shoppingItemDao.getShoppingItem();

        assert(result).stream().anyMatch(shoppingItemTest -> shoppingItem.isEqual(shoppingItemTest));
    }

    @Test
    public void deleteItemTrue(){
        ShoppingItem shoppingItem = new ShoppingItem(0,"item1",1L,5L);
        ShoppingItem shoppingItem1 = new ShoppingItem(1,"item2",1L,5L);
        shoppingItemDao.insertShoppingItem(shoppingItem);
        shoppingItemDao.insertShoppingItem(shoppingItem1);

        shoppingItemDao.deleteShoppingItem(shoppingItem);
        List<ShoppingItem> result = shoppingItemDao.getShoppingItem();

        assert(result).stream().noneMatch(new Predicate<ShoppingItem>() {
            @Override
            public boolean test(ShoppingItem shoppingItemTest) {
                return shoppingItem.isEqual(shoppingItemTest);
            }
        });
    }

}






