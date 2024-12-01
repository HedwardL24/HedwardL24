package LearnSE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserLoginDao {

    public static User authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT email, password, role FROM account WHERE email=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User();
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));

            // Log sign-in activity
            ActivityLogDao.logActivity("user_signed_in", "User signed in with email: " + email);
        }

        rs.close();
        ps.close();
        conn.close();

        return user;
    }
}


