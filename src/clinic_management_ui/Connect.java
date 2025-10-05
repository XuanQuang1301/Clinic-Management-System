package clinic_management_ui;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
=======
import java.sql.*;
import javax.swing.*;
>>>>>>> 68af0b23c52c9671770ef9de5519e12c470d72e6

public class Connect {
    public static Connection ConnectDB() {
        try {
<<<<<<< HEAD
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
          
            String url = "jdbc:mysql://localhost:3310/clinic_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "dat31505"; 

            Connection con = DriverManager.getConnection(url, user, password);
            return con;
            
        } catch (Exception e) {
            // HIỂN THỊ LỖI RA MÀN HÌNH
            JOptionPane.showMessageDialog(null, 
                "Database Connection Error:\n" + e.getMessage(), 
                "Connection Failed", 
                JOptionPane.ERROR_MESSAGE);
            
            // In chi tiết lỗi ra console để debug
            e.printStackTrace(); 
            
            return null; // Trả về null nếu kết nối thất bại
        }
    }
}
=======
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối CSDL
            String url = "jdbc:mysql://localhost:3306/clinic_management?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "2408"; 

            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL Driver not found: " + e);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database: " + e);
            return null;
        }
    }
}
>>>>>>> 68af0b23c52c9671770ef9de5519e12c470d72e6
