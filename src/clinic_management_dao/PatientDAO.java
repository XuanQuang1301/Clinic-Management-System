package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection conn; 
    // Lấy danh sách tất cả bệnh nhân
    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("full_name"),
                        rs.getString("gender"),
                        rs.getString("phone_number"),
                        rs.getString("date_of_birth"),
                        rs.getString("address"),
                        rs.getString("blood_group"),
                        rs.getString("email"),
                        rs.getString("insurance_number")
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public PatientDAO(){
        
    }
    public PatientDAO(Connection conn) {
        this.conn = conn;
    }
    // Xóa bệnh nhân theo ID
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    // Cập nhật thông tin bệnh nhân
    public boolean updatePatient(Patient p) {
        String sql = "UPDATE patients SET full_name=?, gender=?, phone_number=?, date_of_birth=?, " +
                     "address=?, blood_group=?, email=?, insurance_number=? WHERE patient_id=?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, p.getFullName());
            pst.setString(2, p.getGender());
            pst.setString(3, p.getPhoneNumber());
            pst.setString(4, p.getDateOfBirth());
            pst.setString(5, p.getAddress());
            pst.setString(6, p.getBloodGroup());
            pst.setString(7, p.getEmail());
            pst.setString(8, p.getInsuranceNumber());
            pst.setInt(9, p.getId());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    // Tìm kiếm bệnh nhân
    public List<Patient> searchPatient(String id, String name, String insurance, String gender, String blood) {
        List<Patient> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM patients WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (id != null && !id.isEmpty()) {
            sql.append(" AND CAST(patient_id AS CHAR) LIKE ?");
            params.add("%" + id + "%");
        }
        if (name != null && !name.isEmpty()) {
            sql.append(" AND full_name LIKE ?");
            params.add("%" + name + "%");
        }
        if (insurance != null && !insurance.isEmpty()) {
            sql.append(" AND insurance_number LIKE ?");
            params.add("%" + insurance + "%");
        }
        if (gender != null && !gender.isEmpty()) {
            sql.append(" AND gender = ?");
            params.add(gender);
        }

        if (blood != null && !blood.isEmpty()) {
            sql.append(" AND blood_group = ?");
            params.add("%" + blood + "%");
        }

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql.toString())) {

            // Gán tham số
            for (int i = 0; i < params.size(); i++) {
                pst.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("full_name"),
                        rs.getString("gender"),
                        rs.getString("phone_number"),
                        rs.getString("date_of_birth"),
                        rs.getString("address"),
                        rs.getString("blood_group"),
                        rs.getString("email"),
                        rs.getString("insurance_number")
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean insertPatient(String fullname, String gender, String birthday,
                                String address, String contact, String blood,
                                String insurance, String email) {
        String sql = "INSERT INTO patients (full_name, gender, date_of_birth, address, " +
                     "phone_number, blood_group, insurance_number, email) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, fullname);
            pst.setString(2, gender);
            pst.setString(3, birthday);
            pst.setString(4, address);
            pst.setString(5, contact);
            pst.setString(6, blood);
            pst.setString(7, insurance);
            pst.setString(8, email);

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.err.println("Error saving patient: " + e.getMessage());
            return false;
        }
    }
}
