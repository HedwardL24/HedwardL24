package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.SQLException;

import LearnSE.dao.ActivityLogDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logActivity")
public class LogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String activityType = request.getParameter("activityType");
        String description = request.getParameter("description");

        try {
            ActivityLogDao.logActivity(activityType, description);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void logActivity(String activityType, String description) {
        try {
            ActivityLogDao.logActivity(activityType, description);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    
}


