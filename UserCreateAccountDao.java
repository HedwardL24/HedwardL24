package LearnSE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserCreateAccountDao {

    public static boolean emailExists(String email) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT email FROM account WHERE email=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        ps.close();
        conn.close();
        return exists;
    }

    public static int getNextaid() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT IFNULL(MAX(aid), 0) + 1 AS nextId FROM account";
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

    public static void insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO account (aid, first_name, last_name, email, password, securityQuestion, securityAnswer, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, user.getAccountId());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPassword());
        ps.setString(6, user.getSecurityQuestion());
        ps.setString(7, user.getSecurityAnswer());
        ps.setString(8, user.getRole());
        ps.executeUpdate();
        ps.close();
        conn.close();
        
        ActivityLogDao.logActivity("user_created", "User created with email: " + user.getEmail());
    }
    
}

