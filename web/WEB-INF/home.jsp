<%-- 
    Document   : home
    Created on : 15 Oct, 2021, 10:29:26 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h2>Hello ${user.username}!</h2>
        <a href="login?logout">Log Out</a>
    </body>
</html>
