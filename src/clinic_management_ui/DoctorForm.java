package clinic_management_ui;

import clinic_management_dao.DoctorDAO;
import clinic_management_dao.Doctor;
import static java.lang.reflect.Array.set;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DoctorForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DoctorForm.class.getName());

    private JFrame parentForm;
    
    public DoctorForm(JFrame parent) {
        initComponents();
        tblDoctors.setShowGrid(true);
        tblDoctors.setGridColor(new java.awt.Color(220, 220, 220));
        tblDoctors.setBackground(java.awt.Color.WHITE);
        jScrollPane2.getViewport().setBackground(java.awt.Color.WHITE);
        this.parentForm = parent;
        loadDoctorsToTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void loadDoctorsToTable() {
        DoctorDAO dao = new DoctorDAO(); 
        List<Doctor> doctorList = dao.getAllDoctors();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctors = new javax.swing.JTable();
        btnAddDoctor = new javax.swing.JButton();
        btnDeleteDoctor = new javax.swing.JButton();
        btnUpdateDoctor = new javax.swing.JButton();
        LabelSearchCriteria = new javax.swing.JLabel();
        LabelSearchTerm = new javax.swing.JLabel();
        SearchCriteria = new javax.swing.JComboBox<>();
        txtSearchDoctor = new javax.swing.JTextField();
        btnSearchDoctor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Patient");

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Doctor");

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setText("Department");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setText("Appointment");

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setText("Medical Record");

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton11.setText("Bill");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setText("Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Clinic Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton8)
                        .addComponent(jButton7)
                        .addComponent(jButton6)
                        .addComponent(jButton5)
                        .addComponent(jButton10)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(24, 24, 24))
        );

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

        btnAddDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddDoctor.setText("Add doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        btnDeleteDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteDoctor.setText("Delete doctor");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
            }
        });

        btnUpdateDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateDoctor.setText("Update doctor");
        btnUpdateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDoctorActionPerformed(evt);
            }
        });

        LabelSearchCriteria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSearchCriteria.setText("SearchCriteria:");

        LabelSearchTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSearchTerm.setText("SearchTerm:");

        SearchCriteria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchCriteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên bác sĩ", " " }));
        SearchCriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCriteriaActionPerformed(evt);
            }
        });

        txtSearchDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearchDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearchDoctor.setText("Search doctor");
        btnSearchDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnUpdateDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LabelSearchTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LabelSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchDoctor)
                            .addComponent(SearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(btnSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelSearchTerm)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnSearchDoctor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDoctor)
                    .addComponent(btnUpdateDoctor)
                    .addComponent(btnDeleteDoctor))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void SearchCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCriteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCriteriaActionPerformed

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

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton btnSearchDoctor;
    private javax.swing.JButton btnUpdateDoctor;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDoctors;
    private javax.swing.JTextField txtSearchDoctor;
    // End of variables declaration//GEN-END:variables

    private void populateDoctorTable(List<Doctor> searchResult) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
