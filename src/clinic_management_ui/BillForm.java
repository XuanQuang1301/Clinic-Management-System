package clinic_management_ui;

import clinic_management_dao.BillDAO;
import clinic_management_dao.BillDisplay;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BillForm extends javax.swing.JFrame {

    private javax.swing.JTable tblBills;
    private javax.swing.JTextField txtBillId;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JButton btnSearchBill;
    private javax.swing.JButton btnPayBill;
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JButton btnDashboard;

    public BillForm() {
        initComponents();
        Get_Data();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        setTitle("Quản lý hóa đơn");
        setSize(1050, 500); // Tăng chiều rộng để chứa thêm cột CreatedAt
        setLocationRelativeTo(null);

        tblBills = new javax.swing.JTable();
        txtBillId = new javax.swing.JTextField();
        txtPatientId = new javax.swing.JTextField();
        cmbPaymentStatus = new javax.swing.JComboBox<>(new String[]{"Tất cả", "Unpaid", "Paid"});
        btnSearchBill = new javax.swing.JButton("Tìm kiếm");
        btnPayBill = new javax.swing.JButton("Thanh toán");
        btnDeleteBill = new javax.swing.JButton("Xóa");
        btnDashboard = new javax.swing.JButton("Dashboard");

        tblBills.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "BillID", "PatientName", "DoctorName", "Department", "TotalAmount", "PaymentStatus", "CreatedAt"
                }
        ));

        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tblBills);

        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(null);

        txtBillId.setBounds(20, 20, 100, 40);
        txtBillId.setBorder(javax.swing.BorderFactory.createTitledBorder("Bill ID"));
        panel.add(txtBillId);

        txtPatientId.setBounds(140, 20, 100, 40);
        txtPatientId.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient ID"));
        panel.add(txtPatientId);

        cmbPaymentStatus.setBounds(260, 20, 120, 40);
        panel.add(cmbPaymentStatus);

        btnSearchBill.setBounds(400, 20, 100, 40);
        panel.add(btnSearchBill);

        btnPayBill.setBounds(520, 20, 120, 40);
        panel.add(btnPayBill);

        btnDeleteBill.setBounds(660, 20, 100, 40);
        panel.add(btnDeleteBill);

        btnDashboard.setBounds(780, 20, 100, 40);
        panel.add(btnDashboard);

        scrollPane.setBounds(20, 80, 1000, 350);
        panel.add(scrollPane);

        add(panel);

        btnSearchBill.addActionListener(e -> btnSearchBillActionPerformed(null));
        btnPayBill.addActionListener(e -> btnPayBillActionPerformed(null));
        btnDeleteBill.addActionListener(e -> btnDeleteBillActionPerformed(null));
        btnDashboard.addActionListener(e -> {
            DashboardForm dashboard = new DashboardForm(this);
            dashboard.setVisible(true);
            this.dispose();
        });
    }

    private void Get_Data() {
        BillDAO dao = new BillDAO();
        List<BillDisplay> bills = dao.getAllBillsForDisplay();
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        model.setRowCount(0);
        for (BillDisplay b : bills) {
            model.addRow(new Object[]{
                b.getBillId(),
                b.getPatientName(),
                b.getDoctorName(),
                b.getDepartmentName(),
                b.getTotalAmount(),
                b.getPaymentStatus(),
                b.getCreatedAt() // Thêm cột này
            });
        }
    }

    private void btnSearchBillActionPerformed(java.awt.event.ActionEvent evt) {
        String id = txtBillId.getText().trim();
        String patientId = txtPatientId.getText().trim();
        String status = cmbPaymentStatus.getSelectedItem().toString();

        BillDAO dao = new BillDAO();
        List<BillDisplay> result = dao.getAllBillsForDisplay();
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        model.setRowCount(0);
        for (BillDisplay b : result) {
            if (!id.isEmpty() && b.getBillId() != Integer.parseInt(id)) continue;
            if (!patientId.isEmpty() && !b.getPatientName().contains(patientId)) continue;
            if (!status.equals("Tất cả") && !b.getPaymentStatus().equalsIgnoreCase(status)) continue;
            model.addRow(new Object[]{
                b.getBillId(),
                b.getPatientName(),
                b.getDoctorName(),
                b.getDepartmentName(),
                b.getTotalAmount(),
                b.getPaymentStatus(),
                b.getCreatedAt() // Thêm cột này
            });
        }
    }

    private void btnPayBillActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblBills.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để thanh toán.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int billId = (int) tblBills.getValueAt(selectedRow, 0);
        BillDAO dao = new BillDAO();
        boolean ok = dao.updatePaymentStatus(billId, "Paid");
        if (ok) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
            Get_Data();
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblBills.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int billId = (int) tblBills.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            BillDAO dao = new BillDAO();
            boolean ok = dao.deleteBill(billId);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công.");
                Get_Data();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new BillForm().setVisible(true);
        });
    }
}