package clinic_management_dao; 
import clinic_management_ui.Connect; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Đăng nhập
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    // So sánh trực tiếp
                    if (password.equals(storedPassword)) {
                        return extractUserFromResultSet(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy thông tin user
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setFullName(rs.getString("full_name"));
        user.setEmail(rs.getString("email"));
        return user;
    }

    // Đổi mật khẩu (không dùng băm)
    public boolean changePassword(int userId, String oldPassword, String newPassword) {
        String sqlSelect = "SELECT password FROM users WHERE user_id = ?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement psSelect = conn.prepareStatement(sqlSelect)) {
            
            psSelect.setInt(1, userId);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    String currentPassword = rs.getString("password");
                    if (oldPassword.equals(currentPassword)) {
                        String sqlUpdate = "UPDATE users SET password = ? WHERE user_id = ?";
                        try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                            psUpdate.setString(1, newPassword);
                            psUpdate.setInt(2, userId);
                            int rowsAffected = psUpdate.executeUpdate();
                            return rowsAffected > 0;
                        }
                    } else {
                        System.out.println("Mật khẩu cũ không đúng!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
