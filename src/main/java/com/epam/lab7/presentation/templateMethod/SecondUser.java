package com.epam.lab7.presentation.templateMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondUser extends SimpleText {
    private static final Logger logger = LogManager.getLogger(SecondUser.class);

    public void writeNewMessage() {
        logger.info("I want to sleep... Please, help me");
    }

    public void writeGoodBye() {
        logger.info("Oh no, it is morning!!! Good morning everyone!!!");
    }
}

