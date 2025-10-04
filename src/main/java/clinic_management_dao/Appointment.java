package clinic_management_dao;

import java.sql.Timestamp;
public class Appointment {
    private int appointmentId; 
    private int patientId;
    private int doctorId; 
    private Timestamp appointmentDate; 
    private String reason; 
    private String status; 
    private int roomId;
    public Appointment(){
        
    }
    public Appointment(int appointmentId, int patientId, int doctorId,
                   Timestamp appointmentDate, String reason, String status, int roomId) {
    this.appointmentId = appointmentId;
    this.patientId = patientId;
    this.doctorId = doctorId;
    this.appointmentDate = appointmentDate;
    this.reason = reason;
    this.status = status;
    this.roomId = roomId;
}


    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }
    
}
