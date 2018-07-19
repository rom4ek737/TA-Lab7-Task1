package com.epam.lab7.hw7.task2;

import java.util.List;

public interface MyDAOInterface {
    List<Student> selectAll() throws Exception;
    boolean deleteStudent(int id) throws Exception;
    void insertStudent(Student student) throws Exception;
    Student findStudent(Student student) throws Exception;

}
