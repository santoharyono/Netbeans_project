<%-- 
    Document   : list-student
    Created on : Apr 30, 2018, 9:34:30 AM
    Author     : Santo_HW432
--%>

<%@page import="com.mitraiscdc.mvcexample2.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.mitraiscdc.mvcexample2.controller.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Lists</title>
        <link rel="stylesheet" type="text/css" href="asset/css/style.css">
    </head>
    <body>
        <%
            List<Student> students = (List< Student>) request.getAttribute("STUDENT_LIST");
        %>

        <div id="wrapper">
            <div id="header">
                <h2>Foobar University</h2>        
            </div>
        </div>
        <div id="container">
            <div id="content">
                <input type="button" value="Add Student"
                       onclick="window.location.href='add-student.jsp'" class="add-student-button"/>
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    
                    <c:forEach var="student" items="${STUDENT_LIST}">
                        <!--Setup link for each student-->
                        <c:url var="studentlink" value="student">
                            <c:param name="command" value="LOAD"/>
                            <c:param name="studentId" value="${student.id}"/>
                        </c:url>
                        <c:url var="deletelink" value="student">
                            <c:param name="command" value="DELETE"/>
                            <c:param name="studentId" value="${student.id}"/>
                        </c:url>
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.email}</td>
                        <td><a href="${studentlink}">Update</a> | <a href="${deletelink}"
                                                                     onclick="if(!(confirm('Are you sure want to delete this student?')))
                                                                     return false">Delete</a></td>
                    </tr>    
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
