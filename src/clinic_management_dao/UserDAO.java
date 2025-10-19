package clinic_management_dao; 
import clinic_management_ui.Connect; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = Connect.ConnectDB();
        PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedHashedPassword = rs.getString("password");
                    if (password.equals(storedHashedPassword)) {
                        return extractUserFromResultSet(rs);
                    }
                }
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setFullName(rs.getString("full_name"));        
        user.setEmail(rs.getString("email"));
        return user;
    }

    public boolean changePassword(int userId, String oldPassword, String newPassword) 
    {
        String sqlSelect = "SELECT password FROM users WHERE user_id = ?";
        try (Connection conn = Connect.ConnectDB(); 
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect)) {
            psSelect.setInt(1, userId);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    String HashedPassword = rs.getString("password");
                    if (BCrypt.checkpw(oldPassword, HashedPassword)) {
                        String newHashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
                        String sqlUpdate = "UPDATE users SET password = ? WHERE user_id = ?";
                        try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                            psUpdate.setString(1, newHashedPassword);
                            psUpdate.setInt(2, userId);                        
                            int rowsAffected = psUpdate.executeUpdate();
                            return rowsAffected > 0; 
                        }
                    } 
                    else {
                        System.out.println("Mật khẩu cũ không khớp.");
                        return false;
                    }
                }
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    return false;
    }
    //sau khi doi mat khau xong thi can vào PasswordHasher de lay mat khau duoc bam luu vao csdl
}

