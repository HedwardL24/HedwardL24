package LearnSE.ServletFiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import LearnSE.dao.Article;
import LearnSE.dao.ArticleDao;


@WebServlet("/submitArticle")
public class ArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String articleName = request.getParameter("articleName");
        String authorName = request.getParameter("authorName");
        String content = request.getParameter("content");

        try {
            // Get the next article ID
            int articleId = ArticleDao.getNextArticleId();

            // Create a new Article object
            Article article = new Article();
            article.setArticleId(articleId);
            article.setArticleName(articleName);
            article.setAuthorName(authorName);
            article.setContent(content);

            // Insert the article into the database
            ArticleDao.insertArticle(article);

            response.sendRedirect("articleSuccess.jsp"); // Redirect to success page after article submission
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("submitArticle.jsp?error=An+error+occurred");
        }
    }
}

