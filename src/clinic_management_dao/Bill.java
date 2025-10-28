package clinic_management_dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bill {
    private int billId;
    private int patientId;
    private int doctorId;
    private int departmentId;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private Timestamp createdAt;

    public Bill() {}

    public Bill(int billId, int patientId, int doctorId, int departmentId, BigDecimal totalAmount, String paymentStatus, Timestamp createdAt) {
        this.billId = billId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.departmentId = departmentId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
    }

    // Getter và Setter
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}