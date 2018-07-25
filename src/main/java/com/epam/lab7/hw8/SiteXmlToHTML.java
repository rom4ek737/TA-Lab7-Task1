package com.epam.lab7.hw8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SiteXmlToHTML {
    private static final Logger logger = LogManager.getLogger(SiteXmlToHTML.class);

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(SiteXmlToHTML.class.getClassLoader().getResource("config.properties").getFile()));
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer(new StreamSource(new File(prop.getProperty("strXSL"))));
            StreamSource source = new StreamSource(new File(prop.getProperty("strXML")));
            StreamResult sr = new StreamResult(new File(prop.getProperty("strHTML")));
            logger.info(source.getPublicId());
            logger.info(tf.getOutputProperties());
            logger.info(tff.getAssociatedStylesheet(source, "", "title", ""));
            tf.transform(source, sr);
            logger.info("Transformed!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}