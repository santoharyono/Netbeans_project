<%-- 
    Document   : functionExample
    Created on : Apr 26, 2018, 9:06:16 AM
    Author     : Santo_HW432
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Function JSTL</title>
    </head>
    <body>
        <c:set var="data" value="StringForCount"/>
        Length for the string <b>${data}</b> : ${fn:length(data)}
        <br/>
        Uppercase for <b>${data}</b> : ${fn:toUpperCase(data)}
    </body>
</html>
