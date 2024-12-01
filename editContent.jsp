<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Edit Content</title>
</head>
<body>
    <h2>Edit Content</h2>
    <form method="post" action="EditContentServlet">
        <input type="hidden" id="contentId" name="contentId" value="${content.contentId}">
        
        <label for="contentTitle">Content Title:</label>
        <input type="text" id="contentTitle" name="contentTitle" value="${content.contentTitle}" required><br><br>

        <label for="contentDetails">Content Details:</label>
        <textarea id="contentDetails" name="contentDetails" required>${content.contentDetails}</textarea><br><br>

        <button type="submit">Update Content</button>
    </form>
</body>
</html>
