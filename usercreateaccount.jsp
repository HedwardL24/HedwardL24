<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
    <link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
</head>
<meta charset="UTF-8">
<body>
	<%@ include file="/headmenu.jsp"%>
    <h2>Lets Create An Account</h2>
    <form method="post" action="createAccount">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="securityQuestion">Security Question:</label>
        <select id="securityQuestion" name="securityQuestion" required>
            <option value="" disabled selected>Select your security question</option>
            <option value="DadName">What is your Dad's name?</option>
            <option value="firstPet">What was the name of your first pet?</option>
            <option value="favoriteSport">What is your favorite sport?</option>
            <option value="birthCity">In what city were you born?</option>
        </select><br><br>
        
        <label for="securityAnswer">Answer:</label>
        <input type="text" id="securityAnswer" name="securityAnswer" required><br><br>

        <button type="submit">Create Account</button>
    </form>
</body>
</html>
