<%-- 
    Document   : student
    Created on : Apr 25, 2018, 9:08:01 AM
    Author     : Santo_HW432
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Hi ${param.firstName}, ${param.lastName}</h1>
        You are from ${param.country} and your favorite programming language is ${param.programmingLanguage}
        <br/>
        Your hobbies are :
        <ul>
            <% String[] hobbies = request.getParameterValues("hobby");
            if (hobbies.length > 0) {
                for (String hobby : hobbies) {
                    out.println("<li>" + hobby + "</li>");
                }
            }
            %>
        </ul>
    </body>
</html>
