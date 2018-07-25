package com.epam.lab7.hw8.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseXMLWithSAX {
    private static final Logger logger = LogManager.getLogger(ParseXMLWithSAX.class);
    public static void main(String[] args) throws Exception{
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean title = false;
                boolean siteType = false;
                boolean email = false;
                boolean news = false;
                boolean archive = false;
                boolean vouting = false;
                boolean paid = false;
                boolean authorize = false;

                public void startElement(String uri, String localName, String qname, Attributes attributes) throws SAXException {
                   // logger.info("Start element: " + qname);
                    if (qname.equalsIgnoreCase("title")) {
                        title = true;
                    }
                    if (qname.equalsIgnoreCase("siteType")) {
                        siteType = true;
                    }
                    if (qname.equalsIgnoreCase("email")) {
                        email = true;
                    }
                    if (qname.equalsIgnoreCase("news")) {
                        news = true;
                    }
                    if (qname.equalsIgnoreCase("archive")) {
                        archive = true;
                    }
                    if (qname.equalsIgnoreCase("vouting")) {
                        vouting = true;
                    }
                    if (qname.equalsIgnoreCase("paid")) {
                        paid = true;
                    }
                    if (qname.equalsIgnoreCase("authorize")) {
                        authorize = true;
                    }
                }
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                   // System.out.println("End Element :" + qName);

                }
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (title) {
                        System.out.println("Title : " + new String(ch, start, length));
                        title = false;
                    }

                    if (siteType) {
                        System.out.println("Type of site : " + new String(ch, start, length));
                        siteType = false;
                    }

                    if (email) {
                        System.out.println("Email : " + new String(ch, start, length));
                        email = false;
                    }

                    if (news) {
                        System.out.println("News : " + new String(ch, start, length));
                        news = false;
                    }
                    if (archive) {
                        System.out.println("Archive : " + new String(ch, start, length));
                        archive = false;
                    }

                    if (vouting) {
                        System.out.println("Vouting : " + new String(ch, start, length));
                        vouting = false;
                    }
                    if (paid) {
                        System.out.println("Paid : " + new String(ch, start, length));
                        paid = false;
                    }

                    if (authorize) {
                        System.out.println("Authorize : " + new String(ch, start, length));
                        authorize = false;
                    }
                }
            };
            saxParser.parse("src\\main\\resources\\mySite.xml", handler);
        }
        catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }