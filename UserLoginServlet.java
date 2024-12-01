package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.SQLException;
import LearnSE.dao.User;
import LearnSE.dao.UserLoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = UserLoginDao.authenticate(email, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if ("admin".equals(user.getRole())) {
                    response.sendRedirect("homepage3.jsp"); // Redirect to admin homepage
                } else {
                    response.sendRedirect("homepage2.jsp"); // Redirect to user homepage
                }
            } else {
                response.sendRedirect("userlogin.jsp?error=Invalid+email+or+password");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("userlogin.jsp?error=An+error+occurred");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



