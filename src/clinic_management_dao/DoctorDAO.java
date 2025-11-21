
package clinic_management_dao;
import clinic_management_dao.Doctor;
import clinic_management_dao.Gender;
import clinic_management_ui.Connect; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author nguye
 */
public class DoctorDAO {
    private Connection conn; 
    public DoctorDAO(Connection conn){
        this.conn = conn; 
    }
    public DoctorDAO(){

    }
    public static List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        String sql = "SELECT doctor_id, full_name, email, gender, specialization, department_id, phone_number, date_of_birth FROM doctors";

        try (Connection conn = Connect.ConnectDB(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setEmail(rs.getString("email"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setDepartmentId(rs.getInt("department_id"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                if (rs.getString("gender") != null) {
                    doctor.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
                }
                java.sql.Date dobSql = rs.getDate("date_of_birth");  
                if (dobSql != null) {
                doctor.setDateOfBirth(dobSql.toLocalDate());  
                }
                doctorList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return doctorList;
    }
    public boolean deleteDoctor(int doctorId) throws SQLException
    {
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        try(Connection conn = Connect.ConnectDB(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, doctorId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected >0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean add(Doctor doctor) throws SQLException
    {
        String sql = "INSERT INTO doctors (full_name, date_of_birth, gender, email, phone_number,department_id, specialization) VALUE(?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = Connect.ConnectDB(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getFullName());
            ps.setDate(2, java.sql.Date.valueOf(doctor.getDateOfBirth()));
            ps.setString(3, doctor.getGender().name());  
            ps.setString(4, doctor.getEmail());
            ps.setString(5, doctor.getPhoneNumber());
            ps.setInt(6, doctor.getDepartmentId());
            ps.setString(7, doctor.getSpecialization());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    public List<Doctor> searchDoctor(String searchTerm) {
    List<Doctor> doctorList = new ArrayList<>();

    if (searchTerm == null || searchTerm.trim().isEmpty()) {
        return doctorList; 
    }

    String sql = """
        SELECT d.*
        FROM doctors d
        JOIN departments dp ON d.department_id = dp.department_id
        WHERE d.full_name LIKE ?
        ORDER BY d.full_name
    """;

    try (Connection conn = Connect.ConnectDB();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        String searchPattern = "%" + searchTerm.trim() + "%";
        ps.setString(1, searchPattern);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setEmail(rs.getString("email"));

                String genderStr = rs.getString("gender");
                if (genderStr != null) {
                    doctor.setGender(Gender.valueOf(genderStr.toUpperCase()));
                }

                java.sql.Date dobSql = rs.getDate("date_of_birth");
                if (dobSql != null) {
                    doctor.setDateOfBirth(dobSql.toLocalDate());
                }

                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setDepartmentId(rs.getInt("department_id"));

                doctorList.add(doctor);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return doctorList;
}



public Doctor getDoctorById(int doctorId) throws SQLException
{
    String sql = "SELECT * FROM doctors WHERE doctor_id = ?";
    try(Connection conn = Connect.ConnectDB();  PreparedStatement ps = conn.prepareStatement(sql))
    {
        ps.setInt(1, doctorId);
        try(ResultSet rs = ps.executeQuery())
        {
            if(rs.next())
            {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setEmail(rs.getString("email"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setDepartmentId(rs.getInt("department_id"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                if (rs.getString("gender") != null) {
                    doctor.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
                }
                java.sql.Date dobSql = rs.getDate("date_of_birth");
                if(dobSql != null)
                {
                    doctor.setDateOfBirth(dobSql.toLocalDate());
                }
                return doctor;
            }
        }

    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return null;  
}
public boolean updateDoctor(Doctor doctor) throws SQLException
{
    String sql = "UPDATE doctors SET full_name =?, date_of_birth=?, gender=?, email = ?, phone_number = ?, department_id = ?, specialization = ? WHERE doctor_id = ?";
    try(Connection conn = Connect.ConnectDB();  PreparedStatement ps = conn.prepareStatement(sql))
    {
        ps.setString(1, doctor.getFullName());
        ps.setDate(2, java.sql.Date.valueOf(doctor.getDateOfBirth()));
        ps.setString(3, doctor.getGender().name());
        ps.setString(4, doctor.getEmail());
        ps.setString(5, doctor.getPhoneNumber());
        ps.setInt(6, doctor.getDepartmentId());
        ps.setString(7, doctor.getSpecialization());
        ps.setInt(8, doctor.getDoctorId()); 
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;

    }
    catch(SQLException e)
    {
        e.printStackTrace();
        return false;
    }
}

}
