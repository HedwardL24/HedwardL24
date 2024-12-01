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

@WebServlet("/forgotPassword")
public class UserForgetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            try {
                // Database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "Mereja0728$");

                // Update password
                String query = "UPDATE users SET password=? WHERE email=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, newPassword);
                ps.setString(2, email);
                int rowsUpdated = ps.executeUpdate();

                conn.close();
                

                if (rowsUpdated > 0) {
                    response.sendRedirect("userlogin.jsp?message=Password+changed+successfully");
                } else {
                    response.sendRedirect("forgotPassword.jsp?error=Email+not+found");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendRedirect("userforgetpassword.jsp?error=An+error+occurred");
            }
        } else {
            response.sendRedirect("useforgetpassword.jsp?error=Passwords+do+not+match");
        }
    }
    
}


