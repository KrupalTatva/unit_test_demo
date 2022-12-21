package com.example.unittestdemo.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingItemTest {

    ShoppingItem shoppingItem1 , shoppingItem2;

    @Before
    public void setUp() throws Exception {
        shoppingItem1 = new ShoppingItem(0,"dfgsf",0L,0L);
        shoppingItem2 = new ShoppingItem(1,"dfrg",2L,25L);
    }

    @Test
    public void shoppingItemEmptyFalse(){
        boolean result = shoppingItem1.isEmpty();
        assertTrue(result);
    }

    @Test
    public void shoppingItemEmptyTrue(){
        boolean result = shoppingItem2.isEmpty();
        assertFalse(result);
    }

    @After
    public void tearDown() throws Exception {
    }
}