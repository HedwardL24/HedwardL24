<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
</head>
<body>
	<%@ include file="/headmenu.jsp"%>
    <header>
        <h1>Contact Barry University</h1>
    </header>
    <main>
        <!-- Introduction Section -->
        <section>
            <h2>We’re Here to Help</h2>
            <p>Thank you for visiting Barry University’s Department of Computer Science and Mathematics. If you have any questions, need support, or want to learn more about our programs, don’t hesitate to contact us using the information below.</p>
        </section>

        <!-- Contact Information -->
        <section>
            <h2>Contact Information</h2>
            <ul>
                <li><strong>Email:</strong> <a href="mailto:info@barry.edu">info@barry.edu</a></li>
                <li><strong>Phone:</strong> <a href="tel:+13058907777">+1 (305) 899-7777</a></li>
                <li><strong>Address:</strong> <br>
                    Barry University <br>
                    11300 NE 2nd Ave <br>
                    Miami Shores, FL 33161 <br>
                </li>
            </ul>
        </section>

        <!-- Contact Form -->
        <section>
            <h2>Send Us a Message</h2>
            <p>If you’d like to contact us online, please fill out the form below and a representative will get back to you shortly:</p>
            <form action="submitContactForm" method="post">
                <label for="name">Your Name:</label><br>
                <input type="text" id="name" name="name" placeholder="Enter your full name" required><br><br>
                
                <label for="email">Your Email:</label><br>
                <input type="email" id="email" name="email" placeholder="Enter your email address" required><br><br>
                
                <label for="message">Your Message:</label><br>
                <textarea id="message" name="message" rows="5" cols="40" placeholder="Enter your message" required></textarea><br><br>
                
                <button type="submit">Submit</button>
            </form>
        </section>

        <!-- Google Map Embed -->
        <section>
            <h2>Find Us on the Map</h2>
            <p>Barry University is located in the heart of Miami Shores, Florida. Use the map below to find our campus:</p>
            <iframe 
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14552.010742036152!2d-80.1967198053845!3d25.879331801792894!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x88d9ab93627b0bf9%3A0xe5541613cdb6a8da!2sBarry%20University!5e0!3m2!1sen!2sus!4v1691169652111!5m2!1sen!2sus" 
                width="100%" 
                height="450" 
                style="border:0;" 
                allowfullscreen="" 
                loading="lazy">
            </iframe>
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Department of Computer Science and Mathematics, Barry University</p>
    </footer>
</body>
</html>

