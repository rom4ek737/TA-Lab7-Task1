package com.epam.lab7.hw8.task8;

public class TestJaxb {
    public static void main(String[] args) {
        SiteJaxb siteJaxb = new SiteJaxb();
        siteJaxb.marshall();
        siteJaxb.unmarshall();
    }
}
