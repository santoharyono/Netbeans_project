<%-- 
    Document   : student
    Created on : Apr 27, 2018, 9:35:09 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <form action="StudentServlet" method="GET">
            <input type="text" name="firstname" placeholder="First Name"/><br/><br/>
            <input type="text" name="lastname" placeholder="Last Name"/><br/>
            <br/>
            <input type="submit" value="Send"/>
        </form>
    </body>
</html>
