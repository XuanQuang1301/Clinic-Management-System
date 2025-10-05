package clinic_management_dao;

import clinic_management_ui.Connect;  
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public boolean add(Department department) {
        String sql = "INSERT INTO departments (department_name, description, consultation_fee) VALUES (?, ?, ?)";
        try (Connection conn = Connect.ConnectDB(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, department.getDepartmentName());
            ps.setString(2, department.getDescription());
            ps.setBigDecimal(3, department.getConsultationFee());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public static List<Department> getAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        String sql = "SELECT department_id, department_name, description, consultation_fee FROM departments";

        try (Connection conn = Connect.ConnectDB();   
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setConsultationFee(rs.getBigDecimal("consultation_fee"));
                departmentList.add(department);
            }

        } catch (SQLException e) {
        }
        return departmentList;
    }

    public boolean deleteDepartment(int departmentId) {
        String sql = "DELETE FROM departments WHERE department_id = ?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, departmentId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean updatePDepartment(Department p) {
        String sql = "UPDATE departments SET department_name=?, description=?, consultation_fee=? WHERE department_id=?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setInt(1, p.getDepartmentId());
            pst.setString(2, p.getDepartmentName());
            pst.setString(3, p.getDescription());
            pst.setBigDecimal(4, p.getConsultationFee());
            

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public List<Department> searchDepartments(String id, String name, String fee) {
        List<Department> departmentList = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM departments WHERE 1=1");

        if (id != null && !id.trim().isEmpty()) {
            sql.append(" AND department_id = ?");
        }
        if (name != null && !name.trim().isEmpty()) {
            sql.append(" AND department_name LIKE ?");
        }
        if (fee != null && !fee.trim().isEmpty()) {
            sql.append(" AND consultation_fee LIKE ?");
        }

        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;

            if (id != null && !id.trim().isEmpty()) {
                ps.setInt(paramIndex++, Integer.parseInt(id));
            }
            if (name != null && !name.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
            }
            if (fee != null && !fee.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + fee + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Department department = new Department();
                    department.setDepartmentId(rs.getInt("department_id"));
                    department.setDepartmentName(rs.getString("department_name"));
                    department.setDescription(rs.getString("description"));
                    department.setConsultationFee(rs.getBigDecimal("consultation_fee"));
                    departmentList.add(department);
                }
            }

        } catch (SQLException e) {
        }
        return departmentList;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 68af0b23c52c9671770ef9de5519e12c470d72e6
