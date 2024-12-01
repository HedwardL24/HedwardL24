<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Content</title>
</head>
<meta charset="UTF-8">
<body>
    <h2>Delete Content</h2>
    <form method="post" action="DeleteContentServlet">
        <input type="hidden" id="contentId" name="contentId" value="${content.contentId}">
        
        <p>Are you sure you want to delete the following content?</p>
        
        <p><strong>Content Title:</strong> ${content.contentTitle}</p>
        <p><strong>Content Details:</strong> ${content.contentDetails}</p>

        <button type="submit">Delete Content</button>
    </form>
</body>
</html>
