package com.epam.lab7.hw3.task5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class VoidMethodsTest {
    private static final Logger logger = LogManager.getLogger(VoidMethodsTest.class);

    VoidMethods v = new VoidMethods();

    @Before
    public void doList() {
        v.listElements();
    }

    @Test//(expected = IOException.class)
    public void testFile() throws IOException {
        v.createFile();
        assertTrue("File did not created", v.wasCreated);
        logger.info("File was created");
    }

    @Test
    public void testZeroElementEqualsHello() {
        assertEquals(v.list.get(0), "Hello");
        logger.info("Test completed");
    }

    @Test
    public void testEmpty() {
        v.listElements();
        assertFalse(v.list.isEmpty());
        logger.info("Test 2 completed");
    }

    @Test
    public void testSize() {
        assertEquals(3, v.list.size());
        logger.info("List has 3 elements");
    }
    @Test
    public void secondElement() {
        assertNotNull(v.list);
        logger.info("Not empty");
    }
}
