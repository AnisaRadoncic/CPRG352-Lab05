<%-- 
    Document   : login
    Created on : 15 Oct, 2021, 10:07:30 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <label>
                Username:
            </label>
            <input type="text" name="username" value="${user.username}"><br>
          <label>
                Password:
            </label>
            <input type="text" name="password" value="${user.password}"><br>
            <input type="submit" name="submitbutton" value="Log in">
        </form>
        <h4>${invalidLogin}</h4>
        <h4>${loggedOut}</h4>
    </body>
</html>
