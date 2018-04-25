<%-- 
    Document   : SessionExample
    Created on : Apr 25, 2018, 10:30:22 AM
    Author     : Santo_HW432
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Example</title>
    </head>
    <body>
        <form action="SessionExample.jsp">
            Add new Item : <input type="text" name="todoList"/>
            <input type="submit" value="Add"/>
        </form>
        <%
            List<String> todos = (List<String>) session.getAttribute("todolist");

            if (todos == null) {
                todos = new ArrayList<String>();
                session.setAttribute("todolist", todos);
            }

            String todo = request.getParameter("todoList");
            if (todo != null && !todo.trim().equals("")) {
                todos.add(todo);
            }
        %>
        <hr/>
        <b>Todo List :</b>
        <ol>
            <%
                for (String item : todos) {
                    out.println("<li>" + item + "</li>");
                }
            %>
        </ol>
    </body>
</html>
