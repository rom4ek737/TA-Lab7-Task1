package com.epam.lab7.hw8.task8;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Site")
public class Sites {
    private String title;
    private String siteType;
    private String email;
    private String news;
    private String archive;
    private String vouting;
    private String paid;
    private String authorize;

    public Sites(String title, String siteType, String email, String news, String archive, String vouting, String paid, String authorize) {
        super();
        this.title = title;
        this.siteType = siteType;
        this.email = email;
        this.news = news;
        this.archive = archive;
        this.vouting = vouting;
        this.paid = paid;
        this.authorize = authorize;
    }

    public Sites() {
        super();
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @XmlElement
    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    @XmlElement
    public String getVouting() {
        return vouting;
    }

    public void setVouting(String vouting) {
        this.vouting = vouting;
    }

    @XmlElement
    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    @XmlElement
    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }
}
