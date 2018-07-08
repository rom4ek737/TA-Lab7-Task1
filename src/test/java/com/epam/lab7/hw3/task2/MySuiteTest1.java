package com.epam.lab7.hw3.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class MySuiteTest1 {
    private MySuite cl1;

    @Before
    public void setUp() {
        this.cl1 = new MySuite();
        System.out.println("Starting before");
    }

    @Test
    public void testAMoreThanB() {
        assertFalse("a not more than b", cl1.difference(1, 9));
        System.out.println("Test 4 completed");
    }

    @Test
    public void testArrayItemMy() {
        cl1.myContains();
        assertSame(cl1.list.get(0), "My");
        System.out.println("Test completed");
    }
}
