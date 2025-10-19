/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinic_management_ui;

import clinic_management_dao.DoctorDAO;
import clinic_management_dao.Doctor;
import static java.lang.reflect.Array.set;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class DoctorManagementForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DoctorManagementForm.class.getName());
    private JFrame parentForm;

    public DoctorManagementForm(JFrame parent) {
        initComponents();
        tblDoctors.setShowGrid(true);
        tblDoctors.setGridColor(new java.awt.Color(220, 220, 220));
        tblDoctors.setBackground(java.awt.Color.WHITE);
        jScrollPane2.getViewport().setBackground(java.awt.Color.WHITE);
        this.parentForm = parent;
        loadDoctorsToTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    public void loadDoctorsToTable() {
        List<Doctor> doctorList = DoctorDAO.getAllDoctors();
        DefaultTableModel model = (DefaultTableModel) tblDoctors.getModel();
        model.setRowCount(0);
        for (Doctor doctor : doctorList) {
            model.addRow(new Object[]{
                doctor.getDoctorId(),
                doctor.getFullName(),
                doctor.getEmail(),
                doctor.getGender(),
                doctor.getDateOfBirth(),
                doctor.getPhoneNumber(),
                doctor.getSpecialization(),});
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddDoctor = new javax.swing.JButton();
        btnDeleteDoctor = new javax.swing.JButton();
        txtSearchDoctor = new javax.swing.JTextField();
        btnSearchDoctor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctors = new javax.swing.JTable();
        btnUpdateDoctor = new javax.swing.JButton();
        btnReturnAdminForm = new javax.swing.JButton();
        LabelSearchCriteria = new javax.swing.JLabel();
        LabelSearchTerm = new javax.swing.JLabel();
        SearchCriteria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Doctor management");

        btnAddDoctor.setText("Add doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        btnDeleteDoctor.setText("Delete doctor");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
            }
        });

        btnSearchDoctor.setText("Search doctor");
        btnSearchDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDoctorActionPerformed(evt);
            }
        });

        tblDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên bác sĩ", "Email", "Giới tính", "Ngày sinh", "Số điện thoại", "Chuyên khoa"
            }
        ));
        jScrollPane2.setViewportView(tblDoctors);

        btnUpdateDoctor.setText("Update doctor");
        btnUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDoctorActionPerformed(evt);
            }
        });

        btnReturnAdminForm.setText("Return AdminForm");
        btnReturnAdminForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnAdminFormActionPerformed(evt);
            }
        });

        LabelSearchCriteria.setText("SearchCriteria:");

        LabelSearchTerm.setText("SearchTerm:");

        SearchCriteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên bác sĩ", " " }));
        SearchCriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCriteriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelSearchTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(SearchCriteria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane2)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturnAdminForm))
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchDoctor)
                    .addComponent(LabelSearchTerm))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAddDoctor)
                        .addGap(37, 37, 37)
                        .addComponent(btnDeleteDoctor)
                        .addGap(47, 47, 47)
                        .addComponent(btnUpdateDoctor)
                        .addGap(42, 42, 42)
                        .addComponent(btnReturnAdminForm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed

        AddDoctorDialog dialog = new AddDoctorDialog(this, true);
        dialog.setVisible(true);
        loadDoctorsToTable();
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoctorActionPerformed

        int selectedRow = tblDoctors.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bác sĩ để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bác sĩ này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int doctorId = Integer.parseInt(tblDoctors.getValueAt(selectedRow, 0).toString());
                DoctorDAO doctorDAO = new DoctorDAO();
                boolean isDeleted = doctorDAO.deleteDoctor(doctorId);

                if (isDeleted) {

                    DefaultTableModel model = (DefaultTableModel) tblDoctors.getModel();
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Xóa bác sĩ thành công!");
                } else {

                    JOptionPane.showMessageDialog(this, "Xóa bác sĩ thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "ID của bác sĩ không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                System.err.println("Lỗi khi parse ID bác sĩ: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                System.err.println("Lỗi khi xóa bác sĩ: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnDeleteDoctorActionPerformed

    private void populateDoctorTable(List<Doctor> doctorList) {
        DefaultTableModel model = (DefaultTableModel) tblDoctors.getModel();
        model.setRowCount(0);
        for (Doctor doctor : doctorList) {
            Object[] row = new Object[]{
                doctor.getDoctorId(),
                doctor.getFullName(),
                doctor.getEmail(),
                doctor.getGender(),
                doctor.getDateOfBirth(),
                doctor.getPhoneNumber(),
                doctor.getSpecialization(),
                doctor.getDepartmentId(),};
            model.addRow(row);
        }
    }
    private void btnSearchDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDoctorActionPerformed

        String searchTerm = txtSearchDoctor.getText().trim();
        String searchBy = (String) SearchCriteria.getSelectedItem();
        DoctorDAO doctorDAO = new DoctorDAO();
        if (searchTerm.isEmpty()) {
            loadDoctorsToTable();
            return;
        }
        List<Doctor> searchResult = doctorDAO.searchDoctor(searchTerm, searchBy);
        populateDoctorTable(searchResult);
        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy bác sĩ nào phù hợp với từ khóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadDoctorsToTable();
        } else {
            populateDoctorTable(searchResult);
        }
    }//GEN-LAST:event_btnSearchDoctorActionPerformed

    private void btnUpdateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDoctorActionPerformed

        int selectedRow = tblDoctors.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bác sĩ để cập nhật.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int doctorId = (int) tblDoctors.getValueAt(selectedRow, 0);
            DoctorDAO doctorDAO = new DoctorDAO();
            Doctor doctorToUpdate = doctorDAO.getDoctorById(doctorId);
            if (doctorToUpdate != null) {
                AddDoctorDialog updateDoctorDialog = new AddDoctorDialog(this, true, doctorToUpdate);
                updateDoctorDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin bác sĩ", "lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateDoctorActionPerformed

    private void btnReturnAdminFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnAdminFormActionPerformed

        if (parentForm != null) {
            parentForm.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnReturnAdminFormActionPerformed

    private void SearchCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCriteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCriteriaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new DoctorForm(null).setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSearchCriteria;
    private javax.swing.JLabel LabelSearchTerm;
    private javax.swing.JComboBox<String> SearchCriteria;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnDeleteDoctor;
    private javax.swing.JButton btnReturnAdminForm;
    private javax.swing.JButton btnSearchDoctor;
    private javax.swing.JButton btnUpdateDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDoctors;
    private javax.swing.JTextField txtSearchDoctor;
    // End of variables declaration//GEN-END:variables
}
