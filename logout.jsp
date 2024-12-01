<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Logout</title>
    <script type="text/javascript">
        function confirmLogout() {
            var result = confirm("Are you sure you want to log out?");
            if (result) {
                window.location.href = "logouthandle.jsp";
            } else {
                window.location.href = "logout.jsp";
            }
        }
    </script>
</head>
<body>
    <h2>Logout</h2>
    <button onclick="confirmLogout()">Logout</button>
</body>
</html>
