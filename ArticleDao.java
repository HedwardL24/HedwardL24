package LearnSE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDao {

    public static int getNextArticleId() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT IFNULL(MAX(article_id), 0) + 1 AS nextId FROM articles";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        int nextId = 1;
        if (rs.next()) {
            nextId = rs.getInt("nextId");
        }
        rs.close();
        ps.close();
        conn.close();
        return nextId;
    }

    public static void insertArticle(Article article) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO articles (artid, article_name, author_name, content) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, article.getArticleId());
        ps.setString(2, article.getArticleName());
        ps.setString(3, article.getAuthorName());
        ps.setString(4, article.getContent());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
