<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
    <title>Logging Out...</title>
</head>
<meta charset="UTF-8">
<body>
    <%
        HttpSession Session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("userlogin.jsp"); // Redirect to login page after logout
    %>
</body>
</html>
