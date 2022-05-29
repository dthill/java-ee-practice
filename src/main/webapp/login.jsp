<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<style>
    form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
<form action="login-controller" method="post">
    <h1>Login</h1>
    <label for="email"></label>
    <input type="email" name="email" id="email" placeholder="email">
    <label for="password"></label>
    <input type="password" name="password" id="password" placeholder="password">
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
            out.print("<span class=\"error\">" + error + "</span>");
        }
    %>
    <span class="error"></span>
    <input type="submit" value="Login">
</form>
</body>
</html>