<%-- 
    Document   : test
    Created on : Apr 25, 2018, 4:23:16 PM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] cities = {"Bandung", "Bali", "Jakarta", "Yogyakarta"};
            pageContext.setAttribute("officeCities", cities);
        %>
        
        <!--Calling office cities using JSTL-->
        <c:set var="servertime" value="<%= new java.util.Date()%>" />
        
        <!--Loop ofiiceCities-->
        <b>Mitrais office location :</b><br/>
        <c:forEach var="officecity" items="${officeCities}">
            ${officecity} <br/>
        </c:forEach><br/>

        Server time is : ${servertime}
    </body>
</html>
