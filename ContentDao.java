package LearnSE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentDao {

    // Retrieve content by ID
    public static Content getContentById(int contentId) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT content_id, content_title, content_details FROM content WHERE content_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, contentId);
        ResultSet rs = ps.executeQuery();

        Content content = null;
        if (rs.next()) {
            content = new Content();
            content.setContentId(rs.getInt("content_id"));
            content.setContentTitle(rs.getString("content_title"));
            content.setContentDetails(rs.getString("content_details"));
        }

        rs.close();
        ps.close();
        conn.close();

        return content;
    }

    // Update content
    public static void updateContent(Content content) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "UPDATE content SET content_title=?, content_details=? WHERE content_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, content.getContentTitle());
        ps.setString(2, content.getContentDetails());
        ps.setInt(3, content.getContentId());
        ps.executeUpdate();

        
        ActivityLogDao.logActivity("content_updated", "Content updated with ID: " + content.getContentId());

        ps.close();
        conn.close();
    }
    
    public static void deleteContentById(int contentId) throws SQLException, ClassNotFoundException { 
    	Connection conn = DBConnection.getConnection();
    	String query = "DELETE FROM content WHERE content_id=?"; 
    	PreparedStatement ps = conn.prepareStatement(query); 
    	ps.setInt(1, contentId); 
    	ps.executeUpdate(); 
 
    	
    	ActivityLogDao.logActivity("content_deleted", "Content deleted with ID: " + contentId);
    	ps.close();
    	conn.close(); 
    	}
    }

