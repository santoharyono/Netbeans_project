<%-- 
    Document   : add-student
    Created on : Apr 30, 2018, 2:08:42 PM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Student</title>
        <link rel="stylesheet" type="text/css" href="asset/css/style.css">
        <link rel="stylesheet" type="text/css" href="asset/css/add-student-style.css">
    </head>
    <body>
        <div id="container">
            <h3>Add Student</h3>
            <form action="student" method="GET">
                <input type="hidden" name="command" value="ADD"/>
                <table>
                    <tbody>
                        <tr>
                            <td><label>First Name:</label></td>
                            <td><input type="text" name="firstname"/></td>
                        </tr>
                        <tr>
                            <td><label>Last Name:</label></td>
                            <td><input type="text" name="lastname"/></td>
                        </tr>
                        <tr>
                            <td><label>Email</label></td>
                            <td><input type="text" name="email"/></td>
                        </tr>
                        <tr>
                            
                            <td><input type="submit" value="Save" class="save"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <div style="clear: both;"></div>
            <p>
                <a href="student">Back to List</a>
            </p>
        </div>
    </body>
</html>
