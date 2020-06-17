package com.company.jdbcexamplefive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe" , "SYSTEM" , "sunshine");

        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into emp values(?,?,?)");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter emp ID");
            int e_id = scanner.nextInt();

            System.out.println("Enter employee name");
            String e_name = scanner.next();

            System.out.println("Enter employee salary");
            double e_sal = scanner.nextDouble();

            preparedStatement.setInt(1,e_id);
            preparedStatement.setString(2,e_name);
            preparedStatement.setDouble(3,e_sal);
            preparedStatement.executeUpdate();

            System.out.println("Values inserted successfully ..... Do you want one more record yes/no: ");
            String option = scanner.next();
            if (option.equals("no"))
                break;
        }
        preparedStatement.close();
        scanner.close();
        connection.close();
        System.out.println("Connection close successfully");
    }

}
