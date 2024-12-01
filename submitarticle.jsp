<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Article</title>
</head>
<body>
<meta charset="UTF-8">
    <h2>Submit Article</h2>
    <form method="post" action="submitArticle">
        <label for="articleName">Article Name:</label>
        <input type="text" id="articleName" name="articleName" required><br><br>

        <label for="authorName">Author Name:</label>
        <input type="text" id="authorName" name="authorName" required><br><br>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="15" cols="30" required></textarea><br><br>

        <button type="submit">Submit Article</button>
    </form>
</body>
</html>
