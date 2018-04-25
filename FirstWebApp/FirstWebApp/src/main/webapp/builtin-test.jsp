<%-- 
    Document   : builtin-test
    Created on : Apr 25, 2018, 8:38:48 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Built in Object in JSP</title>
    </head>
    <body>
        Request user agent : <%= request.getHeader("User-Agent") %>
        <br/><br/>
        Request language : <%= request.getLocale() %>
    </body>
</html>
