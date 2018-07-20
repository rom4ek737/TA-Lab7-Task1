package com.epam.lab7.hw7.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySQLQuery {
    static Student student = new Student();
    private static final Logger logger = LogManager.getLogger(MySQLQuery.class);

    public static void main(String[] args) throws Exception{
        logger.info(student.getStudent(1).getFname());
        //dao.readDataBase();
        logger.info(student.getAllUsers().toString());
        student.updateStudent(student.getStudent(3));
        student.deleteStudent(4);
        student.deleteStudent(5);
        student.createStudent();
    }
}
