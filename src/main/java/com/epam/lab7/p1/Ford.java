package com.epam.lab7.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/* This is concrete product */

public class Ford implements Auto {
    private static final Logger logger = LogManager.getLogger(Ford.class);

    public void readAuto() {
        logger.info("This is Ford");
    }
}
