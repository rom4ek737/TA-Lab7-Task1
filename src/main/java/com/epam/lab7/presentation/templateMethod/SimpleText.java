package com.epam.lab7.presentation.templateMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SimpleText {
    private static final Logger logger = LogManager.getLogger(SimpleText.class);

    public void seeTheTrace(String name) {
        helloEveryone(name);
        work();
        writeNewMessage();
        writeGoodBye();
    }

    public void helloEveryone(String name) {
        logger.info("Hello, my name is " + name);
    }

    public void work() {
        logger.info("I am working....");
    }

    abstract void writeNewMessage();

    abstract void writeGoodBye();
}
