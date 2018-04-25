<%-- 
    Document   : personalizePage
    Created on : Apr 25, 2018, 2:07:55 PM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personalize Page</title>
    </head>
    <body>
        <form action="resultpage.jsp">
            Select your favorite programming language :
        <select name="favoriteLanguage">
            <option>Java</option>
            <option>Go lang</option>
            <option>Scala</option>
            <option>Ruby</option>
            <option>Javascript</option>
        </select><br/>
        <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
