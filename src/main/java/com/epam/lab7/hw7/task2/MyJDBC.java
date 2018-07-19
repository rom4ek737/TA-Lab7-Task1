package com.epam.lab7.hw7.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class MyJDBC {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final Logger logger = LogManager.getLogger(MyJDBC.class);

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
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", user, password);

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
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from stud");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int user = resultSet.getInt("stud_no");
            String website = resultSet.getString("stud_fname");
            String summary = resultSet.getString("stud_lname");
            String date = resultSet.getString("stud_adress");
            int comment = resultSet.getInt("stud_phone");
            logger.info("User: " + user);
            logger.info("Website: " + website);
            logger.info("summary: " + summary);
            logger.info("Date: " + date);
            logger.info("Comment: " + comment);
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
        } catch (Exception e) {
        }
    }
}






