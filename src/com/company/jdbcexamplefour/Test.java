package com.company.jdbcexamplefour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe" , "SYSTEM" , "sunshine");
        System.out.println("Connection created successfully...........");
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter employee ID");
            int e_id = scanner.nextInt();

            System.out.println("Enter employee name");
            String e_name = scanner.next();

            System.out.println("Enter employee salary");
            double e_sal = scanner.nextDouble();

            String q = "insert into emp values(" + e_id + " ,'" + e_name + "', " + e_sal + ")";
            System.out.println(q);
            statement.executeUpdate(q);

            System.out.println("Value inserted successfully.... Do you want more records Yes/No::");

            String option = scanner.next();
            if (option.equals("no")){
                break;
            }

        }
        scanner.close();
        statement.close();
        connection.close();
    }
}
