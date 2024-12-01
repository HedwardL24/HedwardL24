<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage User Privileges</title>
	<link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
	<link rel="stylesheet" type="text/css" href="regpriv.css.css">
</head>
<meta charset="UTF-8">
<body>
    <h2>Manage User Privileges</h2>
    <%@ include file="/headmenu3.jsp"%>
    <div class="content">
        <h2>Default Privileges for Admins</h2>
        <p>As an Admin, you have the following privileges:</p>
        <ul>
            <li>View public content</li>
            <li>Access free resources</li>
            <li>Browse the website</li>
            <li>Add content</li>
            <li>Create, Modify, Delete Content</li>
            <li>Change Privileges for Others</li>
            <li>Write and Delete Articles</li>
        </ul>
        <p>You have the best privileges on the website.</p>
    </div>
    <form action="adminchangepriv.jsp">
        <button type="submit">Change Permissions</button>
    </form>
</body>
</html>
