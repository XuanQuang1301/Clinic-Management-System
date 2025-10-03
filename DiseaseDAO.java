package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.*;

public class DiseaseDAO {

    // Thêm bệnh mới
    public boolean addDisease(String name, String description, String treatment, int departmentId) {
        String sql = "INSERT INTO diseases (disease_name, description, treatment, department_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, treatment);
            ps.setInt(4, departmentId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Sửa thông tin bệnh
    public boolean updateDisease(int id, String name, String description, String treatment, int departmentId) {
        String sql = "UPDATE diseases SET disease_name=?, description=?, treatment=?, department_id=? WHERE disease_id=?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, treatment);
            ps.setInt(4, departmentId);
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa bệnh
    public boolean deleteDisease(int id) {
        String sql = "DELETE FROM diseases WHERE disease_id=?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả bệnh
    public List<Disease> getAllDiseases() {
        List<Disease> list = new ArrayList<>();
        String sql = "SELECT * FROM diseases";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Disease d = new Disease();
                d.setDiseaseId(rs.getInt("disease_id"));
                d.setDiseaseName(rs.getString("disease_name"));
                d.setDescription(rs.getString("description"));
                d.setTreatment(rs.getString("treatment"));
                d.setDepartmentId(rs.getInt("department_id"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
