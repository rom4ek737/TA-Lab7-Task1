package com.epam.lab7.hw7.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class MetaData {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private static final Logger logger = LogManager.getLogger(MetaData.class);

    private void writeMetaData(ResultSet resultSet) throws SQLException {

        logger.info("The columns in the table are: ");
        logger.info("Table: " + resultSet.getMetaData().getTableName(1));
        System.out.print("Number     \t" + "Name\t\t\t" + "Type\t\t" + "Size\t\t\t" + "isNull\t\t\t " + "is AI\t\t" + "Signed");
        System.out.println();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.printf("Column %-5s", +i);
                System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
                System.out.printf("%-15s", resultSet.getMetaData().getColumnTypeName(i));
                System.out.printf("%-15s", resultSet.getMetaData().getColumnDisplaySize(i));
                System.out.printf("%-15s", resultSet.getMetaData().isNullable(i));
                System.out.printf("%-15s", resultSet.getMetaData().isAutoIncrement(i));
                System.out.printf("%-15s", resultSet.getMetaData().isSigned(i));
                System.out.println();
            }
        }

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
            resultSet = statement.executeQuery("SELECT * FROM stud");
            writeMetaData(resultSet);
            resultSet = statement.executeQuery("SELECT * FROM subject");
            writeMetaData(resultSet);
            resultSet = statement.executeQuery("SELECT * FROM spec");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
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
