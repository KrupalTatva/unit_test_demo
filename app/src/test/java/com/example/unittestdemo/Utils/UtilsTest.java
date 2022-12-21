package com.example.unittestdemo.Utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkIsValidEmpty() {
        boolean result = Utils.checkIsValid("","df","df");
        assertFalse(result);
    }

    @Test
    public void checkIsValidFalse() {
        boolean result = Utils.checkIsValid("xyz","df","dfg");
        assertFalse(result);
    }

    @Test
    public void checkIsValidTrue() {
        boolean result = Utils.checkIsValid("xyz","df","df");
        assertTrue(result);
    }
}