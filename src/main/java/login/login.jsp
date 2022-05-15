<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login-controller" method="post">
        <label for="email"></label>
        <input type="email" name="email" id="email" placeholder="email">
        <label for="password"></label>
        <input type="password" name="password" id="password" placeholder="password">
        <input type="submit" value="Login">
    </form>
</body>
</html>