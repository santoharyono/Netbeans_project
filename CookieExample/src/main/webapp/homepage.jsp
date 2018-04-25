<%-- 
    Document   : homepage
    Created on : Apr 25, 2018, 2:20:08 PM
    Author     : Santo_HW432
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h3>Training Portal</h3>
        <%
            String favLang = "Java";

//            Get cookies
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("cookieexample.favoritelanguage".equals(cookie.getName())) {
                        favLang = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        break;
                    }
                }
            }
        %>
        
        <h4>New books for <%= favLang %></h4>
        <ul>
            <li>Blah..blah</li>
        </ul>
        <h4>Latest news for <%= favLang %></h4>
        <ul>
            <li>Blah..blah</li>
        </ul>
        <h4>Hot jobs for <%= favLang %></h4>
        <ul>
            <li>Blah..blah</li>
        </ul>
        <hr/>
        <a href="personalizePage.jsp">back to personal page</a>
    </body>
</html>
