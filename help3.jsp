<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Help Page</title>
    <link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
</head>
<body>
	<%@ include file="/headmenu3.jsp"%>
    <header>
        <h1>Help Center</h1>
    </header>
    <main>
        <!-- FAQs Section -->
        <section>
            <h2>Frequently Asked Questions</h2>
            <ul>
                <li><strong>How do I reset my password?</strong> <br>Go to the User Authentication page and click "Forgot Password."</li>
                <li><strong>Who can I contact for support?</strong> <br>Email us at support@yourdomain.com or call (123) 456-7890.</li>
                <li><strong>How do I navigate this website?</strong> <br>Use the menu at the top of the page to access different sections.</li>
            </ul>
        </section>

        <!-- Contact Support Section -->
        <section>
            <h2>Contact Support</h2>
            <p>If you need further assistance, please fill out the form below to contact our support team:</p>
            <form action="submitHelpRequest" method="post">
                <label for="name">Your Name:</label><br>
                <input type="text" id="name" name="name" required><br><br>
                
                <label for="email">Your Email:</label><br>
                <input type="email" id="email" name="email" required><br><br>
                
                <label for="message">Message:</label><br>
                <textarea id="message" name="message" rows="5" cols="40" required></textarea><br><br>
                
                <button type="submit">Submit</button>
            </form>
        </section>

        <!-- Quick Links Section -->
        <section>
            <h2>Quick Links</h2>
            <ul>
                <li><a href="home3.jsp">Home</a></li>
                <li><a href="contact3.jsp">Contact Us</a></li>
                <li><a href="user_auth.jsp">User Authentication</a></li>
            </ul>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Department of Computer Science and Mathematics</p>
    </footer>
</body>
</html>