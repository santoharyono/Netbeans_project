<%-- 
    Document   : internationalizationpage
    Created on : Apr 26, 2018, 10:12:10 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!--Setting locale and store it in the session-->
<c:set var="mylocale" 
           value="${not empty param.mylocale ? param.mylocale : pageContext.request.locale}" 
           scope="session"/>
    <fmt:setLocale value="${mylocale}"/>
    <fmt:setBundle basename="com.mitraiscdc.tagdemo.i18n.resources.mylabels"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internationalization</title>
    </head>
    <body>
        <a href="internationalizationpage.jsp?mylocale=en_US">English (US)</a>
        |
        <a href="internationalizationpage.jsp?mylocale=es_ES">Spanish (ES)</a>
        |
        <a href="internationalizationpage.jsp?mylocale=de_DE">German (DE)</a>
        |
        <hr/>
        <fmt:message key="label.greeting"/><br/><br/>
        <fmt:message key="label.firstname"/> : <i>Katelyn</i><br/>
        <fmt:message key="label.lastname"/> : <i>Schroeder</i><br/><br/>
        <fmt:message key="label.welcome"/><br/><br/>
        <hr/>
        Selected Locale : ${mylocale}
    </body>
</html>
