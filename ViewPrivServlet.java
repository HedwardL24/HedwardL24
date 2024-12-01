package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewPrivileges")
public class ViewPrivServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");

        try {
            // Database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "Mereja0728$");

            // Retrieve current role
            String query = "SELECT role FROM users WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userEmail);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String currentRole = rs.getString("role");
                request.setAttribute("currentRole", currentRole);
                request.setAttribute("userEmail", userEmail);
                request.getRequestDispatcher("adminchangepriv.jsp").forward(request, response);
            } else {
                response.sendRedirect("adminchangepriv.jsp?error=Email+not+found");
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("adminchangepriv.jsp?error=An+error+occurred");
        }
    }
}

