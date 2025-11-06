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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private LocalDate parseDate(String dobStr, int patientId) {
        if (dobStr == null || dobStr.isEmpty()) {
            return null;
        }
        try {
            // Thử định dạng 1: dd-MM-yyyy (hoặc dd/MM/yyyy)
            String normalizedStr = dobStr.replace('/', '-');
            return LocalDate.parse(normalizedStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e1) {
            try {
                // Thử định dạng 2: yyyy-MM-dd
                return LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e2) {
                // Báo lỗi nếu cả 2 đều thất bại
                System.err.println("Lỗi định dạng ngày '" + dobStr + "' cho patient_id: " + patientId);
                return null;
            }
        }
    }

 
    private Patient mapRowToPatient(ResultSet rs) throws SQLException {
        int patientId = rs.getInt("patient_id");

        // Gọi hàm parseDate
        LocalDate dob = parseDate(rs.getString("date_of_birth"), patientId);

        // Xử lý BloodGroup
        String bloodGroupStr = rs.getString("blood_group");
        BloodGroup bg = null;
        if (bloodGroupStr != null && !bloodGroupStr.isEmpty()) {
            try {
                bg = BloodGroup.valueOf(bloodGroupStr.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Giá trị blood_group không hợp lệ: '" +
                        bloodGroupStr + "' cho patient_id: " + patientId);
            }
        }

        // Tạo đối tượng Patient
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
                    // Chỉ cần gọi hàm mapRowToPatient
                    list.add(mapRowToPatient(rs));
                } catch (Exception e_inner) {
                    System.err.println("Lỗi xử lý dòng cho patient_id (bỏ qua): " + e_inner.getMessage());
                }
            }
        } catch (SQLException e_outer) {
            e_outer.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Lỗi SQL nghiêm trọng khi tải danh sách: " + e_outer.getMessage(),
                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public PatientDAO() {
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Không thể xóa bệnh nhân.\nLỗi SQL: " + e.getMessage() +
                "\n\n(Có thể do bệnh nhân này vẫn còn Lịch hẹn hoặc Hồ sơ bệnh án?)",
                "Lỗi Ràng buộc Database", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean updatePatient(Patient p) {
        String sql = "UPDATE patients SET full_name=?, gender=?, phone_number=?, date_of_birth=?, " +
                     "address=?, blood_group=?, email=?, insurance_number=? WHERE patient_id=?";

        if (p == null) return false;

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

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

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
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

//        if (id != null && !id.isEmpty()) {
//            sql.append(" AND CAST(patient_id AS CHAR) LIKE ?");
//            params.add("%" + id + "%");
//        }
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
//        if (blood != null && !blood.isEmpty()) {
//            sql.append(" AND blood_group = ?");
//            params.add(blood);
//        }

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                pst.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                try {
                    // Chỉ cần gọi hàm mapRowToPatient
                    list.add(mapRowToPatient(rs));
                } catch (Exception e_inner) {
                    System.err.println("Lỗi xử lý dòng (tìm kiếm, bỏ qua): " + e_inner.getMessage());
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

        if (p == null) return false; // Dòng này giờ đã đúng

        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Tất cả code dưới đây giờ sẽ hoạt động
            pst.setString(1, p.getFullName());
            pst.setString(2, p.getGender());

            if (p.getDateOfBirth() != null) {
                // LỖI 2: Sửa typo getDateOfFBirth() -> getDateOfBirth()
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
//
//    public boolean insertPatient(String p, String gender, String birthday, String address, String contact, String blood, String insurance, String email) {
//        String sql = "INSERT INTO patients (full_name, gender, date_of_birth, address, " +
//                     "phone_number, blood_group, insurance_number, email) " +
//                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        
//        if (p == null) return false;
//
//        try (Connection con = Connect.ConnectDB();
//             PreparedStatement pst = con.prepareStatement(sql)) {
//
//            pst.setString(1, p.getFullName());
//            pst.setString(2, p.getGender());
//
//            if (p.getDateOfBirth() != null) {
//                pst.setDate(3, Date.valueOf(p.getDateOfFBirth())); // Chú ý: Cần có .valueOf(LocalDate)
//            } else {
//                pst.setNull(3, java.sql.Types.DATE);
//            }
//            
//            pst.setString(4, p.getAddress());
//            pst.setString(5, p.getPhoneNumber());
//
//            if (p.getBloodGroup() != null) {
//                pst.setString(6, p.getBloodGroup().name());
//            } else {
//                pst.setNull(6, java.sql.Types.VARCHAR);
//            }
//            
//            pst.setString(7, p.getInsuranceNumber());
//            pst.setString(8, p.getEmail());
//
//            int rows = pst.executeUpdate();
//            return rows > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,
//                "Lỗi khi lưu bệnh nhân: " + e.getMessage(),
//                "Lỗi Database", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
//}