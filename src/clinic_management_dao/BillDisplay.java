package clinic_management_dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BillDisplay {
    private int billId;
    private String patientName;
    private String doctorName;
    private String departmentName;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private Timestamp createdAt; // Thêm trường này

    public BillDisplay(int billId, String patientName, String doctorName, String departmentName, BigDecimal totalAmount, String paymentStatus, Timestamp createdAt) {
        this.billId = billId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.departmentName = departmentName;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.createdAt = createdAt;
    }

    public int getBillId() { return billId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDepartmentName() { return departmentName; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public Timestamp getCreatedAt() { return createdAt; } // Getter mới
}