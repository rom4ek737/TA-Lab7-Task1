package com.epam.lab7.hw8.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParseXMLWithStAX {
    private static final Logger logger = LogManager.getLogger(ParseXMLWithStAX.class);

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(ParseXMLWithStAX.class.getClassLoader().getResource("config.properties").getFile()));
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(prop.getProperty("auto.path")));
            while (xmlStreamReader.hasNext()) {
                int evenType = xmlStreamReader.getEventType();
                switch (evenType) {
                    case XMLStreamReader.START_ELEMENT:
                        if (xmlStreamReader.getAttributeLocalName(1) != null)
                            logger.info("Start el " + xmlStreamReader.getAttributeLocalName(1));
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (xmlStreamReader.getLocalName() != null)
                            logger.info("Element name" + xmlStreamReader.getLocalName());
                        break;
                    case XMLStreamReader.CHARACTERS:
                        if (xmlStreamReader.getText() != null)
                            logger.info("Data " + xmlStreamReader.getText());
                        break;
                }
                xmlStreamReader.next();
                xmlStreamReader.close();
            }

        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
}
