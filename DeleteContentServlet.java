package LearnSE.ServletFiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;

import LearnSE.dao.Content;
import LearnSE.dao.ContentDao;

@WebServlet("/DeleteContentServlet")
public class DeleteContentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contentId = Integer.parseInt(request.getParameter("contentId"));
        try {
            Content content = ContentDao.getContentById(contentId);
            request.setAttribute("content", content);
            request.getRequestDispatcher("deleteContent.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("deleteContenterror.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contentId = Integer.parseInt(request.getParameter("contentId"));

        try {
            ContentDao.deleteContentById(contentId);
            response.sendRedirect("deleteContentsuccess.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("deleteContenterror.jsp");
        }
    }
}

