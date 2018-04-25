<%-- 
    Document   : homepage
    Created on : Apr 25, 2018, 2:12:41 PM
    Author     : Santo_HW432
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String favLang = request.getParameter("favoriteLanguage");

//        Encode cookie
        favLang = URLEncoder.encode(favLang, "UTF-8");
// Create cookie
        Cookie cookie = new Cookie("cookieexample.favoritelanguage", favLang);
//  Set the lifespan 1 year
        cookie.setMaxAge(60 * 60 * 24 * 365);
//  Send cookie to browser
        response.addCookie(cookie);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        Thanks! we set your favorite programming language to : ${param.favoriteLanguage}
        <br/><br/>
        <a href="homepage.jsp">Return to homepage</a>
    </body>
</html>
