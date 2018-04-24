/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.jdbcexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author Santo_HW432
 */
public class BatchOperationExample {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/javabootcamp";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName(MYSQL_DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            String sqlQuery = "insert into employee(Name, DateOfBirth)values(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter Employee name:");
                String name = reader.readLine();

                System.out.println("Enter Employee date of birth (yyyy-mm-dd):");
                LocalDate dob = LocalDate.parse(reader.readLine());
                java.sql.Date dobDB = java.sql.Date.valueOf(dob);

//                prepare statement
                preparedStatement.setString(1, name);
                preparedStatement.setDate(2, dobDB);

//                prepare batch operation
                preparedStatement.addBatch();

                System.out.println("want to add more records y/n");
                String answer = reader.readLine();
                if (answer.equals("n")) {
                    break;
                }
            }

//            execute batch
            preparedStatement.executeBatch();
            System.out.println("new Employee was inserted successfully");
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
