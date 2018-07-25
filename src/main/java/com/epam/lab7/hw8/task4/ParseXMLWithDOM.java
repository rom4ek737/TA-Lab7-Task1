package com.epam.lab7.hw8.task4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParseXMLWithDOM {

    public static void main(String[] args) throws IOException, NullPointerException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(ParseXMLWithDOM.class.getClassLoader().getResource("config.properties").getFile()));
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder document = dbf.newDocumentBuilder();
            Document doc = document.parse(prop.getProperty("file.path"));
            NodeList nodeList = doc.getElementsByTagName("Site");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element site = (Element) node;
                    String type = site.getAttribute("type");
                    NodeList nl = site.getChildNodes();
                    for (int j = 0; j < nl.getLength(); j++) {
                        Node nd = nl.item(j);
                        if (nd.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) nd;
                            System.out.println("1| " + type + name.getTagName() + name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException ex) {
            ex.printStackTrace();
        }
    }
}
