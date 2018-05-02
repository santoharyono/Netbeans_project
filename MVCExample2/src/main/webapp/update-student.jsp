<%-- 
    Document   : update-student
    Created on : Apr 30, 2018, 4:29:58 PM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
        <link rel="stylesheet" type="text/css" href="asset/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="asset/css/add-student-style.css"/>

    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Foobar University</h2>
            </div>
            <div id="container">
                <h3>Update Student</h3>
                <form action="student" method="GET">
                    <input type="hidden" name="command" value="UPDATE"/>
                    <input type="hidden" name="studentId" value="${STUDENT.id}"/>
                    <table>
                        <tbody>
                            <tr>
                                <td><label>First name:</label></td>
                                <td><input type="text" name="firstname" value="${STUDENT.firstName}"/></td>
                            </tr>
                            <tr>
                                <td><label>Last name:</label></td>
                                <td><input type="text" name="lastname" value="${STUDENT.lastName}"/></td>
                            </tr>
                            <tr>
                                <td><label>Email:</label></td>
                                <td><input type="email" name="email" value="${STUDENT.email}"/></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Save"/></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <div style="clear: both;"></div>
                <p>
                    <a href="student">Back to List</a>
                </p>
            </div>
        </div>
    </body>
</html>
