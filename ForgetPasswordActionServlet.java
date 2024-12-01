package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resetPassword")
public class ForgetPasswordActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            try {
                // Database connection
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "Mereja0728$");

                // Update password
                String query = "UPDATE account SET password=? WHERE email=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, newPassword);
                ps.setString(2, email);
                ps.executeUpdate();

                conn.close();
                response.sendRedirect("userlogin.jsp?message=Password+reset+successful");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("resetpasswordaction.jsp?error=Passwords+do+not+match");
        }
    }
}


