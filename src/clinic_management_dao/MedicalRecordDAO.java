package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    public void synchronizeMedicalRecords() {
        String sql = "INSERT INTO medical_records (appointment_id, patient_id, doctor_id, diagnosis, treatment) " +
                     "SELECT a.appointment_id, a.patient_id, a.doctor_id, '', '' " +
                     "FROM appointments a " +
                     "LEFT JOIN medical_records mr ON a.appointment_id = mr.appointment_id " +
                     "WHERE mr.record_id IS NULL";

        try (Connection conn = Connect.ConnectDB();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.err.println("Error during medical record synchronization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean addMedicalRecord(MedicalRecord record) {
        String sql = "INSERT INTO medical_records (appointment_id, patient_id, doctor_id, diagnosis, treatment) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Connect.ConnectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, record.getAppointmentId());
            ps.setInt(2, record.getPatientId());
            ps.setInt(3, record.getDoctorId());
            ps.setString(4, record.getDiagnosis());  
            ps.setString(5, record.getTreatment());  
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return false; 
        }
    }

    public boolean deleteMedicalRecord(int recordId) {
        String sql = "DELETE FROM medical_records WHERE record_id = ?";
        try (Connection conn = Connect.ConnectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, recordId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return false; 
        }
    }

    
    public boolean updateMedicalRecordDiagnosis(int recordId, String newDiagnosis) {
        String sql = "UPDATE medical_records SET diagnosis = ? WHERE record_id = ?";
        try (Connection conn = Connect.ConnectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newDiagnosis);
            ps.setInt(2, recordId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MedicalRecord> getRecordsByPatientId(int patientId) {
        List<MedicalRecord> list = new ArrayList<>();
        String sql = "SELECT * FROM medical_records WHERE patient_id = ?";
        try (Connection conn = Connect.ConnectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MedicalRecord record = new MedicalRecord();
                    record.setRecordId(rs.getInt("record_id"));
                    record.setAppointmentId(rs.getInt("appointment_id"));
                    record.setPatientId(rs.getInt("patient_id"));
                    record.setDoctorId(rs.getInt("doctor_id"));
                    record.setDiagnosis(rs.getString("diagnosis"));
                    record.setTreatment(rs.getString("treatment"));
                    list.add(record);
                }
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return list;
    }

    public List<MedicalRecordDisplay> getAllRecordsWithDetails() {
        List<MedicalRecordDisplay> list = new ArrayList<>();
        String sql = "SELECT mr.record_id, p.full_name AS patient_name, d.full_name AS doctor_name, " +
                     "a.appointment_date, mr.diagnosis " +
                     "FROM medical_records mr " +
                     "JOIN appointments a ON mr.appointment_id = a.appointment_id " +
                     "JOIN patients p ON a.patient_id = p.patient_id " + 
                     "JOIN doctors d ON a.doctor_id = d.doctor_id " +     
                     "ORDER BY a.appointment_date DESC";
        try (Connection conn = Connect.ConnectDB(); 
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MedicalRecordDisplay record = new MedicalRecordDisplay();
                record.setRecordId(rs.getInt("record_id"));
                record.setPatientName(rs.getString("patient_name"));
                record.setDoctorName(rs.getString("doctor_name"));
                record.setAppointmentDate(rs.getTimestamp("appointment_date"));
                record.setDiagnosis(rs.getString("diagnosis"));
                list.add(record);
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return list;
    }

    public List<MedicalRecordDisplay> searchRecords(String patientName, String doctorName) {
        List<MedicalRecordDisplay> list = new ArrayList<>();
        String sql = "SELECT mr.record_id, p.full_name AS patient_name, d.full_name AS doctor_name, " +
                     "a.appointment_date, mr.diagnosis " +
                     "FROM medical_records mr " +
                     "JOIN appointments a ON mr.appointment_id = a.appointment_id " +
                     "JOIN patients p ON a.patient_id = p.patient_id " +
                     "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                     "WHERE p.full_name LIKE ? AND d.full_name LIKE ? " +
                     "ORDER BY a.appointment_date DESC";
        try (Connection conn = Connect.ConnectDB(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + (patientName != null ? patientName : "") + "%");
            ps.setString(2, "%" + (doctorName != null ? doctorName : "") + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MedicalRecordDisplay record = new MedicalRecordDisplay();
                    record.setRecordId(rs.getInt("record_id"));
                    record.setPatientName(rs.getString("patient_name"));
                    record.setDoctorName(rs.getString("doctor_name"));
                    record.setAppointmentDate(rs.getTimestamp("appointment_date"));
                    record.setDiagnosis(rs.getString("diagnosis"));
                    list.add(record);
                }
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return list;
    }
}
