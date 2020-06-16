package com.company.jdbcexamplethree;

import java.sql.*;

public class Test {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe" , "SYSTEM" , "sunshine");
                Statement statement = connection.createStatement()) {

            String q1 = "select * from emp";
            ResultSet resultSet =  statement.executeQuery(q1);
            System.out.println("Table records -*******************");
            while (resultSet.next()){

                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
