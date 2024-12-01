<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>User Login</title>
    <link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
</head>
<body>
	<%@ include file="/headmenu.jsp"%>
    <h2>User Login</h2>
    <form method="post" action="login">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">Sign In</button>
    </form>
    
    <form action="userforgetpassword.jsp">
        <button type="submit">Forgot Password?</button>
    </form>
</body>
</html>


