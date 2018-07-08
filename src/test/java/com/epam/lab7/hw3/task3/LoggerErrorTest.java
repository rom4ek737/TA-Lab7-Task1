package com.epam.lab7.hw3.task3;

import com.epam.lab7.hw2.task4.TestReflection;
import org.apache.logging.log4j.LogManager;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.*;

public class LoggerErrorTest {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestReflection.class);
    private LoggerError cl1;

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.error(description, e);
        }

        @Override
        protected void succeeded(Description description) {
            logger.info(description);
        }
    };

    @Before
    public void setUp() {
        this.cl1 = new LoggerError();
        System.out.println("Starting before");
    }

    @Test
    public void testAarrayItemMy() throws Exception {
        cl1.myContains();
        logger.error("blablabla");
        assertSame(cl1.list.get(0), "Myi");
        logger.error(new AssertionError());
        assertTrue(true);
        Assert.fail();
    }
}
