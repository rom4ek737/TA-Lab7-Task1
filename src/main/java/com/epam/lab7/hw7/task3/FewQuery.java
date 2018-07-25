package com.epam.lab7.hw7.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class FewQuery {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private static final Logger logger = LogManager.getLogger(FewQuery.class);

    public void readDataBase() throws Exception {
        logger.info("My JDBC testing");
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                logger.info("Driver was find");
            } catch (ClassNotFoundException e) {
                logger.info("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return;
            }
            logger.info("MySQL JDBC Driver Registered!");
            try {
                String user = "root";
                String password = "hellraiser1";
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?setSSL=false", user, password);

            } catch (SQLException e) {
                logger.info("Connection Failed! Check output console");
                e.printStackTrace();
                return;
            }
            if (connect != null) {
                logger.info("You made it, take control your database now!");
            } else {
                logger.info("Failed to make connection!");
            }
            PreparedStatement ps = null;
            try {
                connect.setAutoCommit(false);
                statement = connect.createStatement();
                resultSet = statement.executeQuery("select * from stud");
                writeResultSet(resultSet);
                statement.executeUpdate("CREATE TABLE test (id INT(10) NOT NULL, name VARCHAR(5))");
                ps = connect.prepareStatement("INSERT INTO test(id, name) VALUES(?, ?)");
                ps.setInt(1, 3);
                ps.setString(2, "ht");
                ps.executeUpdate();
                connect.commit();
            } catch (Exception ex) {
                connect.rollback();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int user = resultSet.getInt("stud_no");
            String name = resultSet.getString("stud_fname");
            String surname = resultSet.getString("stud_lname");
            String adress = resultSet.getString("stud_adress");
            int phone = resultSet.getInt("stud_phone");
            logger.info("Stud number: " + user);
            logger.info("First name: " + name);
            logger.info("Last name: " + surname);
            logger.info("Adress: " + adress);
            logger.info("Phone: " + phone);
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        }
        catch (Exception e) {
        }
    }
}