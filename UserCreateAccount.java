package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.SQLException;

import LearnSE.dao.User;
import LearnSE.dao.UserCreateAccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createAccount")
public class UserCreateAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String securityQuestion = request.getParameter("securityQuestion");
        String securityAnswer = request.getParameter("securityAnswer");

        try {
            // Check if the email already exists
            if (UserCreateAccountDao.emailExists(email)) {
                response.sendRedirect("usercreateaccount.jsp?error=Email+already+exists");
                return;
            }

            // Get the next account ID
            int aid = UserCreateAccountDao.getNextaid();

            // Create a new User object
            User user = new User();
            user.setAccountId(aid);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setSecurityQuestion(securityQuestion);
            user.setSecurityAnswer(securityAnswer);
            user.setRole("user");

            // Insert the user into the database
            UserCreateAccountDao.insertUser(user);

            response.sendRedirect("userlogin.jsp"); // Redirect to login page after account creation
        } catch (ClassNotFoundException | SQLException e) {
            ((Throwable) e).printStackTrace();
            response.sendRedirect("usercreateaccount.jsp?error=An+error+occurred");
        }
    }
}





