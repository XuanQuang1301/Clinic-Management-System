package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private Connection conn;

    public BillDAO() {
        this.conn = Connect.ConnectDB();
    }

    public BillDAO(Connection externalConn) {
        this.conn = externalConn;
    }

    // Lấy tất cả hóa đơn
    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM bills ORDER BY bill_id";
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Bill b = new Bill(
                        rs.getInt("bill_id"),
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getInt("department_id"),
                        rs.getBigDecimal("consultation_fee"),
                        rs.getBigDecimal("total_amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("created_at")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllBills: " + e.getMessage());
        }
        return list;
    }

    // Thêm hóa đơn mới
    public boolean insertBill(Bill b) {
        String sql = "INSERT INTO bills (appointment_id, patient_id, doctor_id, department_id, consultation_fee, total_amount, payment_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, b.getAppointmentId());
            pst.setInt(2, b.getPatientId());
            pst.setInt(3, b.getDoctorId());
            pst.setInt(4, b.getDepartmentId());
            pst.setBigDecimal(5, b.getConsultationFee());
            pst.setBigDecimal(6, b.getTotalAmount());
            pst.setString(7, b.getPaymentStatus());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error insertBill: " + e.getMessage());
        }
        return false;
    }

    // Xóa hóa đơn
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

    // Cập nhật trạng thái thanh toán
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

    // Tìm kiếm hóa đơn
    public List<Bill> searchBills(String id, String patientId, String status) {
        List<Bill> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM bills WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (id != null && !id.trim().isEmpty()) {
            sql.append(" AND bill_id = ?");
            params.add(Integer.parseInt(id));
        }
        if (patientId != null && !patientId.trim().isEmpty()) {
            sql.append(" AND patient_id = ?");
            params.add(Integer.parseInt(patientId));
        }
        if (status != null && !status.trim().isEmpty()) {
            sql.append(" AND payment_status = ?");
            params.add(status);
        }

        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pst.setObject(i + 1, params.get(i));
            }
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Bill b = new Bill(
                        rs.getInt("bill_id"),
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getInt("department_id"),
                        rs.getBigDecimal("consultation_fee"),
                        rs.getBigDecimal("total_amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("created_at")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Error searchBills: " + e.getMessage());
        }
        return list;
    }
}