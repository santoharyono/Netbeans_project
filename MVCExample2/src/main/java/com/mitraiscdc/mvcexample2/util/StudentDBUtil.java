/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.mvcexample2.util;

import com.mitraiscdc.mvcexample2.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santo_HW432
 */
public class StudentDBUtil {

    private final String jdbcURL;
    private final String jdbcUser;
    private final String jdbcPassword;
    private Connection jdbcConnection;

    public StudentDBUtil(String jdbcURL, String jdbcUser, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName(Constanta.MYSQL_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null || !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        try {
            String sql = "select * from student";
            connect();

            Statement statement = jdbcConnection.createStatement();
            ResultSet results = statement.executeQuery(sql);

//        Get result
            while (results.next()) {
                int id = results.getInt("id");
                String firstname = results.getString("firstName");
                String lastname = results.getString("lastName");
                String email = results.getString("email");

                Student student = new Student(id, firstname, lastname, email);
                students.add(student);
            }
            return students;
        } finally {
            disconnect();
        }
    }

    public void addStudent(Student newStudent) throws SQLException {
        String sql = "insert into student (firstName, lastName, email)"
                + "values (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, newStudent.getFirstName());
        statement.setString(2, newStudent.getLastName());
        statement.setString(3, newStudent.getEmail());
        boolean insertedRow = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
    }

    public Student getStudent(String studentId) throws SQLException, Exception {
        Student student = null;
        String sql = "select * from student where id=?";
        connect();
        int studentIdParam = Integer.parseInt(studentId);

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, studentIdParam);
        ResultSet result = statement.executeQuery();

        try {
            if (result.first()) {
                int id = result.getInt("Id");
                String firstName = result.getString("FirstName");
                String lastName = result.getString("LastName");
                String email = result.getString("Email");
                student = new Student(id, firstName, lastName, email);
            } else {
                throw new Exception("could not find student id " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            disconnect();
        }

        return student;
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "update student set FirstName = ?, LastName = ?, Email = ?"
                + "where id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getEmail());
        statement.setInt(4, student.getId());

        statement.executeUpdate();

        statement.close();
        disconnect();
    }

    public void deleteStudent(String studentId) throws SQLException, Exception {
        Student deletedStudent = getStudent(studentId);

        if (deletedStudent != null) {
            String sql = "delete from student where id = ?";
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, deletedStudent.getId());

            statement.executeUpdate();
            statement.close();
            disconnect();
        } else {
            throw new Exception("Cannot delete selected student");
        }
    }
}
