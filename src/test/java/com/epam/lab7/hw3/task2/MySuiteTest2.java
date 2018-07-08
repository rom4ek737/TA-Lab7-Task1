package com.epam.lab7.hw3.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class MySuiteTest2 {
    private MySuite cl1;

    @Before
    public void setUp() {
        this.cl1 = new MySuite();
        System.out.println("Starting before");
    }

    @Test
    public void testArrayForNull() {
        cl1.myContains();
        assertNull(cl1.list);
        System.out.println("Test 5 completed");
    }

    @Test
    public void testArrayItemMy() {
        cl1.myContains();
        assertSame(cl1.list.get(0), "Myi");
        System.out.println("Test completed");
    }
}
