package com.epam.lab7.hw7.task2;

class Student extends ConnectionFactory {
    private Integer id;
    private String fname;
    private String lname;
    private Integer phone;

    public Student() {
    }

    public Student(String fname, String lname, Integer phone) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
    }

    public Student(Integer id, String fname, String lname, Integer phone) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
