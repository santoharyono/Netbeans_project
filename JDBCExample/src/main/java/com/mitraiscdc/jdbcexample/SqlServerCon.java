/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santo_HW432
 */
public class SqlServerCon {

    public static void main(String[] args) {
//        Connection configuration
        String connString
                = "jdbc:sqlserver://0.0.0.0:1433;"
                + "database=JavaBootcamp;"
                + "user=sa;"
                + "password=M4ch1nas;"
                //                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

//        Declare JDBC Objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
//            Make connection to sql server database
            connection = DriverManager.getConnection(connString);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            Check if connection established
            if (connection != null) {
                try {

//                    Execute query
                    String sqlQuery = "select * from Employee";
                    statement = connection.createStatement();

//                    Get result from query
                    resultSet = statement.executeQuery(sqlQuery);
//                    Print result
                    List<Employee> employees = new ArrayList<Employee>();
                    while (resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("Id"));
                        employee.setName(resultSet.getString("Name"));
                        employee.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                        employees.add(employee);
                    }

                    for (Employee employee : employees) {
                        System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getDateOfBirth());
                    }
//                    Close connection
                    connection.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
