package LearnSE.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ActivityLogDao {

    public static void logActivity(String activityType, String description) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO log (type, description, time) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, activityType);
        ps.setString(2, description);
        ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}


