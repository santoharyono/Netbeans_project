/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Santo_HW432
 */
public class MySqlCon {
    
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/javabootcamp";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MySqlCon sqlCon = new MySqlCon();

//        Get all employees
        List<Employee> employees = sqlCon.getEmployees();
        employees.forEach(employee -> System.out.printf("%d %s %s%n", employee.getId(), employee.getName(), employee.getDateOfBirth()));

//        Get employee by id
        Employee employee = sqlCon.getEmployee(3);
        System.out.println(employee.getName());

//        Insert new employee
//        Employee newEmployee = new Employee();
//        newEmployee.setId(5);
//        newEmployee.setName("Desta");
//        newEmployee.setDateOfBirth(new Date(1985, 05, 12));
//        boolean isSuccess = sqlCon.insertEmployee(newEmployee);
//        if (isSuccess) {
//            System.out.println("new Employee was inserted successfully");
//        }

//        Update employee
//        Employee updateEmployee = new Employee();
//        updateEmployee.setId(5);
//        updateEmployee.setName("Desta");
//        updateEmployee.setDateOfBirth(new Date(2000, 05, 12));
//        boolean isUpdated = sqlCon.updateEmployee(updateEmployee);
//        if (isUpdated) {
//            System.out.println("new Employee was updated successfully");
//        }

//        Delete employee
        sqlCon.deleteEmployee(5);
    }
    
    public List<Employee> getEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        
        Class.forName(MYSQL_DRIVER);
        try (Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)) {
            if (connection == null) {
                throw new SQLException();
            }
            
            String sql = "select * from employee";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("Id"));
                employee.setName(rs.getString("Name"));
                employee.setDateOfBirth(rs.getDate("DateOfBirth"));
                employees.add(employee);
            }
        }
        return employees;
    }
    
    public Employee getEmployee(int identity) throws SQLException, ClassNotFoundException {
        Employee employeeResult = new Employee();
        
        Class.forName(MYSQL_DRIVER);
        try (Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)) {
            if (connection == null) {
                throw new SQLException();
            }
            
            String sqlQuery = "select * from javabootcamp.employee where Id=?";
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
//            System.out.println(identity);
            prepStatement.setInt(1, identity);
            ResultSet rs = prepStatement.executeQuery();
            
            while (rs.next()) {
                employeeResult.setId(rs.getInt("Id"));
                employeeResult.setName(rs.getString("Name"));
                employeeResult.setDateOfBirth(rs.getDate("DateOfBirth"));
            }
            
        }
        return employeeResult;
    }
    
    public boolean insertEmployee(Employee newEmployee) throws SQLException, ClassNotFoundException {
        boolean result = false;
        
        try (Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)) {
            if (connection == null) {
                throw new SQLException();
            }
            
            String sqlQuery = "insert into employee (Id, Name, DateOfBirth) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, newEmployee.getId());
            preparedStatement.setString(2, newEmployee.getName());
            preparedStatement.setDate(3, java.sql.Date.valueOf(newEmployee.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                result = true;
            }
        }
        
        return result;
    }
    
    public boolean updateEmployee(Employee updateEmployee) throws SQLException, ClassNotFoundException {
        boolean result = false;
        
        try (Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)) {
            if (connection == null) {
                throw new SQLException();
            }
            
            if (getEmployee(updateEmployee.getId()) != null) {
                String sqlQuery = "update employee set Name=?,DateOfBirth=? where Id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, updateEmployee.getName());
                preparedStatement.setDate(2, java.sql.Date.valueOf(updateEmployee.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
                preparedStatement.setInt(3, updateEmployee.getId());
                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    result = true;
                }
            }
        }
        
        return result;
    }
    
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD)) {
            if (connection == null) {
                throw new SQLException();
            }
            
            Employee employeeToDelete = getEmployee(id);
            if (employeeToDelete != null) {
                String sqlQuery = "delete from employee where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, employeeToDelete.getId());
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Record not found");
            }
        }
    }
}
