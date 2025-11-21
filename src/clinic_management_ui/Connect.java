package clinic_management_ui;

import java.sql.*;
import javax.swing.*;

public class Connect {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối CSDL
           // String url = "jdbc:mysql://localhost:3306/clinic_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC-8";
           String url = "jdbc:mysql://localhost:3306/clinic_management"; 
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
