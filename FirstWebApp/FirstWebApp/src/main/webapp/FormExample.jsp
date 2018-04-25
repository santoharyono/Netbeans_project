<%-- 
    Document   : FormExample
    Created on : Apr 25, 2018, 9:00:15 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Example</title>
    </head>
    <body>
        <form action="student.jsp">
            First name : <input type="text" name="firstName" /><br/><br/>
            Last name : <input type="text" name="lastName" /><br/><br/>
            Country : <select name="country">
                <option>Indonesia</option>
                <option>Malaysia</option>
                <option>Australia</option>
                <option>Japan</option>
                <option>India</option>
                <option>United Kingdom</option>
            </select><br/><br/>
            your programming language : <br/><br/>
            <input type="radio" name="programmingLanguage" value="Java"/>Java
            <input type="radio" name="programmingLanguage" value="C#" />C#
            <input type="radio" name="programmingLanguage" value="Javascript" />Javascript
            <input type="radio" name="programmingLanguage" value="Go lang" />Go lang
            <br/><br/>
            Your hobbies : <br/><br/>
            <input type="checkbox" name="hobby" value="Cycling">Cycling
            <input type="checkbox" name="hobby" value="Swimming">Swimming
            <input type="checkbox" name="hobby" value="Travel">Travel
            <input type="checkbox" name="hobby" value="Watch movies">Watch movies
            <input type="checkbox" name="hobby" value="Playing game">Playing game
            <br/><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
<%@include file="footer.jsp" %>
