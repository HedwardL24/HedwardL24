package LearnSE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserForgotPasswordActionDao {

    public static boolean changePassword(PasswordChange passwordChange) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        // Check if the new password is the same as the old password
        String checkPasswordQuery = "SELECT password FROM account WHERE email=?";
        PreparedStatement psCheck = conn.prepareStatement(checkPasswordQuery);
        psCheck.setString(1, passwordChange.getEmail());
        ResultSet rsCheck = psCheck.executeQuery();
        
        if (rsCheck.next()) {
            String currentPassword = rsCheck.getString("password");

            // Ensure the new password isn't the same as the old password
            if (currentPassword.equals(passwordChange.getNewPassword())) {
                rsCheck.close();
                psCheck.close();
                conn.close();
                return false; // New password is the same as the old password
            }

            // Ensure new password matches confirmed password
            if (!passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {
                rsCheck.close();
                psCheck.close();
                conn.close();
                return false; // New password and confirm password do not match
            }

            // Update the password in the database
            String updatePasswordQuery = "UPDATE account SET password=? WHERE email=?";
            PreparedStatement psUpdate = conn.prepareStatement(updatePasswordQuery);
            psUpdate.setString(1, passwordChange.getNewPassword());
            psUpdate.setString(2, passwordChange.getEmail());
            psUpdate.executeUpdate();
            psUpdate.close();

            // Log the activity
            ActivityLogDao.logActivity("password_changed", "Password changed for email: " + passwordChange.getEmail());
            
            rsCheck.close();
            psCheck.close();
            conn.close();
            return true;
        } else {
            rsCheck.close();
            psCheck.close();
            conn.close();
            return false; // Email not found
        }
    }
}

