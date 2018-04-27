<%-- 
    Document   : studentpage
    Created on : Apr 26, 2018, 8:12:52 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*, com.mitraiscdc.tagdemo.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <%
//            generate sample data
            List<Student> students = new ArrayList<Student>();
            students.add(new Student("Katelyn", "Schroeder", false));
            students.add(new Student("George", "Daniel", true));
            students.add(new Student("Moises", "Freeman", false));
            students.add(new Student("Joey", "Reese", false));
            students.add(new Student("Toni", "Sanchez", true));

            pageContext.setAttribute("myStudents", students);
        %>

        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gold Customer</th>
            </tr>
            <!--Loop data-->
            <c:forEach var="student" items="${myStudents}">
                <tr>
                    <td>${student.firstName}</td> 
                    <td>${student.lastName}</td> 
                    <td>
                        <!--if statement jstl-->
                        <%--<c:if test="${student.goldCustomer}">--%>
                            <!--Special Discount-->
                        <%--</c:if>--%>
                        <%--<c:if test="${not student.goldCustomer}">--%>
                            <!----->
                        <%--</c:if>--%>
                        <!--choose statement (switch)-->
                        <c:choose>
                            <c:when test="${student.goldCustomer}">
                                Special Discount
                            </c:when>
                            <c:otherwise>
                                -
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
