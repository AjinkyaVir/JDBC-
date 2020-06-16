package com.company.jdbcexampletwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        // Resource declaration
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection =  DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:xe" , "SYSTEM" , "sunshine");
            System.out.println("Connection created successfully.");

            String q1 = "insert into emp values (111,'aju',20000)";
            String q2 = "insert into emp values (222,'sau',21000)";
            String q3 = "insert into emp values (333,'anu',30000)";

            statement = connection.createStatement();
             statement.executeQuery(q1);
             statement.executeQuery(q2);
             statement.executeQuery(q3);
            System.out.println("Data added successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connection closed successfully.");
        }


    }
}
