package clinic_management_ui;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.*;


public class Connect {
    public static Connection ConnectDB() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
          
            String url = "jdbc:mysql://localhost:3310/clinic_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "dat31505";  
            
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

