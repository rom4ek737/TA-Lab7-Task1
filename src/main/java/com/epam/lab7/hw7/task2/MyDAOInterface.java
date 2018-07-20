package com.epam.lab7.hw7.task2;

import java.util.List;

public interface MyDAOInterface {
    boolean deleteStudent(int id) throws Exception;
    Student getStudent(int student) throws Exception;
    boolean updateStudent(Student student) throws Exception;
    void createStudent() throws Exception;

}
