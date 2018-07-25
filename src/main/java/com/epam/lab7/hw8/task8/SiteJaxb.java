package com.epam.lab7.hw8.task8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SiteJaxb {

    private static final Logger logger = LogManager.getLogger(SiteJaxb.class);

    public void getMyProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(SiteJaxb.class.getClassLoader().getResource("config.properties").getFile()));
    }

    public void marshall() {
        try {
            getMyProperties();
            Sites site = new Sites("Ukr.net", "a", "b", "c", "d", "e", "t", "z");
            JAXBContext jb = JAXBContext.newInstance(Sites.class);
            Marshaller ms = jb.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(site, System.out);
            ms.marshal(site, new File("testMarshall"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void unmarshall() {
        try {
            getMyProperties();
            JAXBContext jb = JAXBContext.newInstance(Sites.class);
            Unmarshaller um = jb.createUnmarshaller();
            Sites sites = (Sites) um.unmarshal(new File("testMarshall"));
            logger.info("Sites ");
            logger.info("Title " + sites.getTitle());
            logger.info("siteType " + sites.getTitle());
            logger.info("email " + sites.getEmail());
            logger.info("news " + sites.getNews());
            logger.info("Archive " + sites.getArchive());
            logger.info("Vouting " + sites.getVouting());
            logger.info("Paid " + sites.getPaid());
            logger.info("Authorize " + sites.getAuthorize());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
