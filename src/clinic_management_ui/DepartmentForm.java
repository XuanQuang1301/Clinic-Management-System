package clinic_management_ui;

import clinic_management_dao.DepartmentDAO;
import clinic_management_dao.Department;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DepartmentForm extends javax.swing.JFrame {
        
    public DepartmentForm() {
        initComponents();
        Get_Data();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
    @SuppressWarnings("unchecked")
   
    private void Get_Data() {
        List<Department> departmentList = DepartmentDAO.getAllDepartment(); 
        DefaultTableModel model = (DefaultTableModel) tblDepartments.getModel();
        model.setRowCount(0);  
        departmentList.forEach(department -> {
            model.addRow(new Object[]{
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getConsultationFee(),
            });
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAddDepartment = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnDeleteDepartment = new javax.swing.JButton();
        txtDepartmentName = new javax.swing.JTextField();
        txtDepartmentId = new javax.swing.JTextField();
        txtConsultationFee = new javax.swing.JTextField();
        btnSearchDepartment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartments = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAddDepartment.setBackground(new java.awt.Color(255, 204, 204));
        btnAddDepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddDepartment.setText("Add department");
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Update");

        btnDeleteDepartment.setBackground(new java.awt.Color(255, 204, 204));
        btnDeleteDepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeleteDepartment.setText("Delete department");
        btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDepartmentActionPerformed(evt);
            }
        });

        txtDepartmentName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDepartmentName.setBorder(javax.swing.BorderFactory.createTitledBorder("Department Name"));
        txtDepartmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentNameActionPerformed(evt);
            }
        });

        txtDepartmentId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDepartmentId.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        txtConsultationFee.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtConsultationFee.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultation Fee"));

        btnSearchDepartment.setBackground(new java.awt.Color(255, 204, 204));
        btnSearchDepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearchDepartment.setText("Search ");
        btnSearchDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDepartmentActionPerformed(evt);
            }
        });

        tblDepartments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Department Name", "Description", "Consultation Fee"
            }
        ));
        jScrollPane1.setViewportView(tblDepartments);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jButton2.setText("Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Doctor");

        jButton4.setText("Appointment");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Medical Record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Clinic Management");

        jButton7.setText("Department");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Bill");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton4)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton7)
                            .addComponent(jButton8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(txtDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)
                                    .addComponent(txtDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(btnAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(95, 95, 95)
                                    .addComponent(jButton1)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtConsultationFee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnDeleteDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)))))
                    .addComponent(btnSearchDepartment))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnSearchDepartment)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultationFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDepartment)
                    .addComponent(jButton1)
                    .addComponent(btnDeleteDepartment))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        AddDepartment addDepartmentDialog = new AddDepartment(this, true);
        addDepartmentDialog.setVisible(true);
        Get_Data();
    }//GEN-LAST:event_btnAddDepartmentActionPerformed

    private void btnDeleteDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDepartmentActionPerformed
        int selectedRow = tblDepartments.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khoa để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } 
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khoa này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        try {         
            int departmentId = Integer.parseInt(tblDepartments.getValueAt(selectedRow, 0).toString());
            DepartmentDAO doctorDAO = new DepartmentDAO();
            boolean isDeleted = doctorDAO.deleteDepartment(departmentId);  
 
            if (isDeleted) {
                
                DefaultTableModel model = (DefaultTableModel) tblDepartments.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Xóa khoa thành công!");
            } else {
               
                JOptionPane.showMessageDialog(this, "Xóa khoa thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
          
            JOptionPane.showMessageDialog(this, "ID của khoa không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            System.err.println("Lỗi khi parse ID bác sĩ: " + e.getMessage());
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            System.err.println("Lỗi khi xóa bác sĩ: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnDeleteDepartmentActionPerformed

    private void populateDepartmentTable(List<Department> departmentList) {
        DefaultTableModel model = (DefaultTableModel) tblDepartments.getModel(); 
        model.setRowCount(0);
        for (Department department : departmentList) {
            Object[] row = new Object[]{
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getConsultationFee(),   
            };
            model.addRow(row);
        }
    }
    private void btnSearchDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDepartmentActionPerformed
        String id = txtDepartmentId.getText().trim();
        String name = txtDepartmentName.getText().trim();
        String fee = txtConsultationFee.getText().trim();

        DepartmentDAO departmentDAO = new DepartmentDAO();

        if (id.isEmpty() && name.isEmpty() && fee.isEmpty()) {
            Get_Data();
            return;
        }

        List<Department> searchResult = departmentDAO.searchDepartments(id, name, fee);

        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Không tìm thấy khoa nào phù hợp với điều kiện tìm kiếm.", 
                "Thông báo", 
                JOptionPane.INFORMATION_MESSAGE);
            Get_Data();
        } else {
            populateDepartmentTable(searchResult);
        }
    }//GEN-LAST:event_btnSearchDepartmentActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PatientForm patientForm = new PatientForm();
        patientForm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDepartmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentNameActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AppointmentForm appointmentForm = new AppointmentForm(); 
        appointmentForm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentForm().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnDeleteDepartment;
    private javax.swing.JButton btnSearchDepartment;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartments;
    private javax.swing.JTextField txtConsultationFee;
    private javax.swing.JTextField txtDepartmentId;
    private javax.swing.JTextField txtDepartmentName;
    // End of variables declaration//GEN-END:variables
}