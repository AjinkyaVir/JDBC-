package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //load the driver (It is automatically register in DMS)
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Oracle drivers are loading...........");

        //Create the connection
        Connection connection =  DriverManager.getConnection
                                ("jdbc:oracle:thin:@localhost:1521:xe" , "SYSTEM" , "sunshine");
        System.out.println("Connection created successfully........" + connection);

        // Step 3: write the query
        String query1 = "create table emp(eid number,ename varchar2(30),esal number)";

        //Step 4 : Process the query
        Statement statement = connection.createStatement();
        int x = statement.executeUpdate(query1);
        System.out.println("Table created successfully.." + x);

        //Step 5: Close the resources
        statement.close();
        connection.close();
        System.out.println("Connection closed");

    }

}
