package clinic_management_dao;

import java.util.Date;

// Class này chỉ để chứa dữ liệu hiển thị, không tương ứng 1-1 với bảng nào
public class MedicalRecordDisplay {
    private int recordId;
    private String patientName;
    private String doctorName;
    private Date appointmentDate;
    private String diseaseName;
    private String diagnosis;

    // Getters and Setters...
    public int getRecordId() { return recordId; }
    public void setRecordId(int recordId) { this.recordId = recordId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getDiseaseName() { return diseaseName; }
    public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}