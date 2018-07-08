package com.epam.lab7.hw3.task1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSampleClass {
private SampleClass cl1;

    @Before
    public void setUp() {
        this.cl1 = new SampleClass();
        System.out.println("Starting before");
    }

    @Test
    public void evenNumber() {
        assertTrue(cl1.isEvenNumber(6));
        System.out.println("Test 1 completed");
    }

    @Test
    public void testDividingByZero() {
        assertEquals(0, cl1.dividing(0, 66));
        System.out.println("Test 2 completed");
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(cl1.list);
        System.out.println("Test 3 completed");
    }

    @Test
    public void testAMoreThanB() {
        assertFalse("a not more than b", cl1.difference(1, 9));
        System.out.println("Test 4 completed");
    }
    @Ignore
    @Test
    public void testArrayForNull() {
        cl1.myContains();
        assertNull(cl1.list);
        System.out.println("Test 5 completed");
    }

    @Test
    public void testArrayItemMy() {
        cl1.myContains();
        assertSame(cl1.list.get(0), "My");
        System.out.println("Test 6 completed");
    }
}
