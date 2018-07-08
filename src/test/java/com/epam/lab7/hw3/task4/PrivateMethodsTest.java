package com.epam.lab7.hw3.task4;

import com.epam.lab7.hw2.task4.TestReflection;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

import static org.junit.Assert.*;

public class PrivateMethodsTest {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestReflection.class);
    PrivateMethods privateMethods;
    Method method;

    @Before
    public void beforeClass() throws Exception {
       privateMethods = new PrivateMethods();
    }

    @Test
    public void testEevenNumber41() throws Exception {
        method = PrivateMethods.class.getDeclaredMethod("isEvenNumber", int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(privateMethods, 41));
        //assertFalse((Boolean) method[1].invoke(privateMethods, 41));
        logger.info("Even number test completed");
    }

    @Test
    public void testOddNumber40() throws Exception {
        method = PrivateMethods.class.getDeclaredMethod("isEvenNumber", int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(privateMethods, 40));
        logger.info("Odd number test completed");
    }

    @Test
    public void testDifferenceBetween5And9() throws Exception {
        method = PrivateMethods.class.getDeclaredMethod("difference", int.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(privateMethods, 5, 9));
        logger.info("Difference between 5 and 9 test completed");
    }
    @Test
    public void testDifferenceBetween11And3() throws Exception {
        method = PrivateMethods.class.getDeclaredMethod("difference", int.class, int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(privateMethods, 11, 3));
        logger.info("Difference between 11 and 3 test completed");
    }

    @Test
    public void isArrayList0equalMy() throws Exception {

        method = PrivateMethods.class.getDeclaredMethod("myContains", String.class);
        method.setAccessible(true);
        assertNotNull(method.invoke(privateMethods, "ololo"));
        //assertFalse(method.getParameterTypes();
        logger.info("Not null element");
    }
    @Test
    public void isArrayList0equalName() throws Exception {
        method = PrivateMethods.class.getDeclaredMethod("myContains", String.class);
        method.setAccessible(true);
        //assertTrue((Boolean) method.invoke(privateMethods, "Hello"));
        logger.info("Equals elements");
        assertEquals(("HelloMy"), (method.invoke(privateMethods, "Hello")));
    }
}
