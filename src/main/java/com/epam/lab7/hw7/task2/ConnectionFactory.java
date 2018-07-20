package com.epam.lab7.hw7.task2;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.nio.charset.Charset;

public class ConnectionFactory implements MyDAOInterface {
    public static final String URL = "jdbc:mysql://localhost:3306/students";
    public static final String USER = "root";
    public static final String PASS = "hellraiser1";
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public Student getStudent(int id) throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stud WHERE stud_no=" + id);
            if (rs.next()) {
                Student user = new Student();
                user.setId(rs.getInt("stud_no"));
                user.setFname(rs.getString("stud_fname"));
                user.setLname(rs.getString("stud_lname"));
                user.setPhone(rs.getInt("stud_phone"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Set getAllUsers() throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stud");
            Set users = new HashSet();
            while (rs.next()) {
                Student student = extractUserFromResultSet(rs);
                users.add(student);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Student extractUserFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("stud_no"));
        student.setFname(rs.getString("stud_fname"));
        student.setLname(rs.getString("stud_lname"));
        student.setPhone(rs.getInt("stud_phone"));
        return student;
    }

    public boolean updateStudent(Student student) throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE stud SET stud_fname=?, stud_lname=?, stud_phone=? WHERE stud_no=?");
            ps.setString(1, "Іван");
            ps.setString(2, student.getLname());
            ps.setInt(3, student.getPhone());
            ps.setInt(4, student.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id) throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM spec WHERE spec_id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void createStudent() throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        Connection connection = cf.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO spec (spec_no, renamed_test, spec_name, desc_spec, raiting, test3) VALUES (2, 3, 4, 5, 7, 5)");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}