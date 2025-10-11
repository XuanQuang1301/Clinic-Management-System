package clinic_management_dao;
import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private Connection conn;

    // Constructor có thể nhận Connection từ ngoài
    public DoctorDAO(Connection conn) {
        this.conn = conn;
    }

    // Nếu không truyền thì tự mở kết nối
    public DoctorDAO() {
        this.conn = Connect.ConnectDB();
    }

    // Lấy tất cả bác sĩ
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY doctor_id";

        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("full_name"),
                        rs.getString("gender"),
                        rs.getString("date_of_birth"), // có thể đổi sang rs.getDate nếu muốn
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("specialization"),
                        rs.getInt("department_id")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllDoctors: " + e.getMessage());
        }
        return list;
    }

    // Thêm bác sĩ
    public boolean insertDoctor(Doctor d) {
        String sql = "INSERT INTO doctors (full_name, gender, date_of_birth, email, phone_number, specialization, department_id) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, d.getFullName());
            pst.setString(2, d.getGender());
            pst.setString(3, d.getDateOfBirth());
            pst.setString(4, d.getEmail());
            pst.setString(5, d.getPhoneNumber());
            pst.setString(6, d.getSpecialization());
            pst.setInt(7, d.getDepartmentId());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error insertDoctor: " + e.getMessage());
        }
        return false;
    }

    // Cập nhật bác sĩ
    public boolean updateDoctor(Doctor d) {
        String sql = "UPDATE doctors SET full_name=?, gender=?, date_of_birth=?, email=?, phone_number=?, specialization=?, department_id=? "
                   + "WHERE doctor_id=?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, d.getFullName());
            pst.setString(2, d.getGender());
            pst.setString(3, d.getDateOfBirth());
            pst.setString(4, d.getEmail());
            pst.setString(5, d.getPhoneNumber());
            pst.setString(6, d.getSpecialization());
            pst.setInt(7, d.getDepartmentId());
            pst.setInt(8, d.getDoctorId());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updateDoctor: " + e.getMessage());
        }
        return false;
    }

    // Xóa bác sĩ theo ID
    public boolean deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE doctor_id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleteDoctor: " + e.getMessage());
        }
        return false;
    }

    // Tìm kiếm bác sĩ theo tên, chuyên khoa hoặc email
    public List<Doctor> searchDoctor(String name, String specialization, String email) {
        List<Doctor> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM doctors WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            sql.append(" AND full_name LIKE ?");
            params.add("%" + name + "%");
        }
        if (specialization != null && !specialization.isEmpty()) {
            sql.append(" AND specialization LIKE ?");
            params.add("%" + specialization + "%");
        }
        if (email != null && !email.isEmpty()) {
            sql.append(" AND email LIKE ?");
            params.add("%" + email + "%");
        }

        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pst.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("full_name"),
                        rs.getString("gender"),
                        rs.getString("date_of_birth"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("specialization"),
                        rs.getInt("department_id")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Error searchDoctor: " + e.getMessage());
        }
        return list;
    }
}
