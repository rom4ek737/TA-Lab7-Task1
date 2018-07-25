package com.epam.lab7.presentation.templateMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstUser extends SimpleText {
    private static final Logger logger = LogManager.getLogger(FirstUser.class);

    public void writeNewMessage() {
        logger.info("I write down the code");
    }

    public void writeGoodBye() {
        logger.info("Good bye!!!");
    }
}
