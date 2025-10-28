package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class BillDAO {
    private Connection conn;

    public BillDAO() {
        this.conn = Connect.ConnectDB();
    }

    public BillDAO(Connection externalConn) {
        this.conn = externalConn;
    }

    public boolean insertBill(Bill b) {
        String sql = "INSERT INTO bills (patient_id, doctor_id, department_id, total_amount, payment_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, b.getPatientId());
            pst.setInt(2, b.getDoctorId());
            pst.setInt(3, b.getDepartmentId());
            pst.setBigDecimal(4, b.getTotalAmount());
            pst.setString(5, b.getPaymentStatus());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error insertBill: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePaymentStatus(int billId, String status) {
        String sql = "UPDATE bills SET payment_status=? WHERE bill_id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, status);
            pst.setInt(2, billId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updatePaymentStatus: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteBill(int billId) {
        String sql = "DELETE FROM bills WHERE bill_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, billId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleteBill: " + e.getMessage());
        }
        return false;
    }

    public List<BillDisplay> getAllBillsForDisplay() {
        List<BillDisplay> list = new ArrayList<>();
        String sql = "SELECT b.bill_id, p.full_name AS patient_name, d.full_name AS doctor_name, dept.department_name AS department_name, b.total_amount, b.payment_status, b.created_at " +
                "FROM bills b " +
                "JOIN patients p ON b.patient_id = p.patient_id " +
                "JOIN doctors d ON b.doctor_id = d.doctor_id " +
                "JOIN departments dept ON b.department_id = dept.department_id " +
                "ORDER BY b.bill_id";
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                BillDisplay bd = new BillDisplay(
                        rs.getInt("bill_id"),
                        rs.getString("patient_name"),
                        rs.getString("doctor_name"),
                        rs.getString("department_name"),
                        rs.getBigDecimal("total_amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("created_at")
                );
                list.add(bd);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllBillsForDisplay: " + e.getMessage());
        }
        return list;
    }
}