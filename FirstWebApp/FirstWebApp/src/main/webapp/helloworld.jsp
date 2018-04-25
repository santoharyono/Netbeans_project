<%-- 
    Document   : helloworld
    Created on : Apr 24, 2018, 4:07:43 PM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mitraiscdc.firstwebapp.FunUtils.*"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello world</title>
    </head>
    <body>
        <h3><%= new String("hello world").toUpperCase()%></h3>
        Server time is <%= new java.util.Date()%>
        <br/><br/>
        JSP Scriptlets example
        <br/><br/>
        <% for (int i = 0; i < 5; i++) {
                out.println("<br/>Number : " + i);
            }%>
        <br/><br/>
        JSP Desclaration example
        <br/>
        <%! String makeItLower(String word) {
                return word.toLowerCase();
            }%>
        result from method makeItLower("HELLO FROM JAVA") is 
        <%= makeItLower("HELLO FROM JAVA")%>
        <br/><br/>
        Calling method in class in JSP
        <br/>
        <%
            String lowerWord = "fun fun fun";
            String upperWord = "Fun Fun FUN";
        %>
        lower word from <% out.println(upperWord); %> is <%= makeItLower(upperWord) %><br/>
        upper word from <% out.println(lowerWord); %> is <%= com.mitraiscdc.firstwebapp.FunUtils.makeItUpper(lowerWord) %><br/>
    </body>
</html>