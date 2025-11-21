package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PatientDAO {

    private Connection conn;

    public PatientDAO(Connection conn) {
        this.conn = conn;
    }

    public PatientDAO() {
        this.conn = Connect.ConnectDB();
    }

    private LocalDate parseDate(String dobStr, int patientId) {
        if (dobStr == null || dobStr.isEmpty()) return null;
        try {
            String normalizedStr = dobStr.replace('/', '-');
            return LocalDate.parse(normalizedStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e1) {
            try {
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e2) {
                System.err.println("Lỗi định dạng ngày '" + dobStr + "' cho patient_id: " + patientId);
                return null;
            }
        }
    }
    
    
    public Patient getPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection con = Connect.ConnectDB(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setInt(1, patientId);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Dùng lại logic mapRowToPatient để chuyển ResultSet thành Patient
                    return mapRowToPatient(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại lỗi để lớp UI có thể xử lý/báo cáo
        }
        return null;
    }
    
    private Patient mapRowToPatient(ResultSet rs) throws SQLException {
        int patientId = rs.getInt("patient_id");
        LocalDate dob = parseDate(rs.getString("date_of_birth"), patientId);

        BloodGroup bg = null;
        String bloodGroupStr = rs.getString("blood_group");
        if (bloodGroupStr != null && !bloodGroupStr.isEmpty()) {
            try {
                bg = BloodGroup.valueOf(bloodGroupStr.trim().toUpperCase());
            } catch (Exception e) {
                System.err.println("Giá trị blood_group không hợp lệ: '" + bloodGroupStr + "' cho patient_id: " + patientId);
            }
        }

        return new Patient(
                patientId,
                rs.getString("full_name"),
                rs.getString("gender"),
                rs.getString("phone_number"),
                dob,
                rs.getString("address"),
                bg,
                rs.getString("email"),
                rs.getString("insurance_number")
        );
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                try {
                    list.add(mapRowToPatient(rs));
                } catch (SQLException e_inner) {
                    System.err.println("Lỗi xử lý dòng cho patient_id (bỏ qua): " + e_inner.getMessage());
                }
            }
        } catch (SQLException e_outer) {
            JOptionPane.showMessageDialog(null,
                "Lỗi SQL nghiêm trọng khi tải danh sách: " + e_outer.getMessage(),
                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            System.out.println("Deleted rows = " + rows + " for id=" + id);
            return rows > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Không thể xóa bệnh nhân.\nLỗi SQL: " + e.getMessage() +
                "\n\n(Có thể do ràng buộc FK)", "Lỗi Ràng buộc Database", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean updatePatient(Patient p) {
        if (p == null) return false;

        String sql = "UPDATE patients SET full_name=?, gender=?, phone_number=?, date_of_birth=?, " +
                     "address=?, blood_group=?, email=?, insurance_number=? WHERE patient_id=?";

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Debug: show id before update
            System.out.println("Attempt update patient_id = " + p.getId());

            pst.setString(1, p.getFullName());
            pst.setString(2, p.getGender());
            pst.setString(3, p.getPhoneNumber());

            if (p.getDateOfBirth() != null) {
                pst.setDate(4, Date.valueOf(p.getDateOfBirth()));
            } else {
                pst.setNull(4, java.sql.Types.DATE);
            }

            pst.setString(5, p.getAddress());

            if (p.getBloodGroup() != null) {
                pst.setString(6, p.getBloodGroup().name());
            } else {
                pst.setNull(6, java.sql.Types.VARCHAR);
            }

            pst.setString(7, p.getEmail());
            pst.setString(8, p.getInsuranceNumber());

            pst.setInt(9, p.getId()); 

            int rows = pst.executeUpdate();
            System.out.println("Rows updated = " + rows + " for patient_id = " + p.getId());
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Lỗi khi cập nhật bệnh nhân: " + e.getMessage(),
                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public List<Patient> searchPatient(String name, String insurance, String gender) {
        List<Patient> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM patients WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            sql.append(" AND full_name LIKE ?");
            params.add("%" + name.trim() + "%");
        }
        if (insurance != null && !insurance.isEmpty()) {
            sql.append(" AND insurance_number LIKE ?");
            params.add("%" + insurance.trim() + "%");
        }
        if (gender != null && !gender.isEmpty()) {
            sql.append(" AND gender = ?");
            params.add(gender.trim());
        }

        sql.append(" ORDER BY patient_id");

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                pst.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    try {
                        list.add(mapRowToPatient(rs));
                    } catch (Exception e_inner) {
                        System.err.println("Lỗi xử lý dòng (tìm kiếm, bỏ qua): " + e_inner.getMessage());
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Lỗi SQL khi tìm kiếm: " + e.getMessage(),
                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public boolean insertPatient(Patient p) {
        String sql = "INSERT INTO patients (full_name, gender, date_of_birth, address, " +
                     "phone_number, blood_group, insurance_number, email) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        if (p == null) return false;

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, p.getFullName());
            pst.setString(2, p.getGender());

            if (p.getDateOfBirth() != null) {
                pst.setDate(3, Date.valueOf(p.getDateOfBirth()));
            } else {
                pst.setNull(3, java.sql.Types.DATE);
            }

            pst.setString(4, p.getAddress());
            pst.setString(5, p.getPhoneNumber());

            if (p.getBloodGroup() != null) {
                pst.setString(6, p.getBloodGroup().name());
            } else {
                pst.setNull(6, java.sql.Types.VARCHAR);
            }

            pst.setString(7, p.getInsuranceNumber());
            pst.setString(8, p.getEmail());

            int rows = pst.executeUpdate();

            // Nếu bạn muốn lấy id sinh tự động (auto-generated id) và gán lại cho object:
            try (ResultSet gen = pst.getGeneratedKeys()) {
                if (gen.next()) {
                    int newId = gen.getInt(1);
                    System.out.println("Inserted new patient_id = " + newId);
                    p.setId(newId);
                }
            } catch (Exception exGen) {
                // không bắt buộc, nhưng tiện để gán id cho object p
            }

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Lỗi khi lưu bệnh nhân: " + e.getMessage(),
                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
