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

@WebServlet("/updatePrivileges")
public class UpdatePrivServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String newRole = request.getParameter("newRole");

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "Mereja0728$");

            // Update user role
            String query = "UPDATE users SET role=? WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newRole);
            ps.setString(2, userEmail);
            ps.executeUpdate();

            conn.close();
            response.sendRedirect("adminchangepriv.jsp?message=Privileges+updated+successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("adminchangepriv.jsp?error=An+error+occurred");
        }
    }
}

