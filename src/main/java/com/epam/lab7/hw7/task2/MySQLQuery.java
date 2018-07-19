package com.epam.lab7.hw7.task2;

public class MySQLQuery {
    public static void main(String[] args) throws Exception{
        MyJDBC dao = new MyJDBC();
        dao.readDataBase();
    }
}
