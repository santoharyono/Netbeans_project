/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.jdbcexample;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Santo_HW432
 */
public class JDBCRowsetExample {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/javabootcamp";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName(MYSQL_DRIVER);

//            creating and executing rowset
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl(DBURL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            String query = "select * from employee";
            rowSet.setCommand(query);
            rowSet.execute();

//            get result
            while (rowSet.next()) {
//            generating cursor moved event
                System.out.println("Id: " + rowSet.getInt("Id"));
                System.out.println("Name: " + rowSet.getString("Name"));
                System.out.println("Date of birth: " + rowSet.getDate("DateOfBirth"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
