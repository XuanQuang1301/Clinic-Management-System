package clinic_management_ui;
import clinic_management_dao.AppointmentDAO;
import clinic_management_dao.Appointment;
import java.awt.HeadlessException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import clinic_management_dao.AppointmentDisplay;
import java.sql.Connection; 
public class AppointmentForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppointmentForm.class.getName());
    private Connection conn; 
    public AppointmentForm() {
        initComponents();
        Get_Data();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    @SuppressWarnings("unchecked")
    private void Get_Data() {
        AppointmentDAO dao = new AppointmentDAO();
        List<AppointmentDisplay> appointmentList = dao.getAllWithNames(); // lấy dữ liệu hiển thị
        DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel(); 
        model.setRowCount(0); // xóa dữ liệu cũ
        appointmentList.forEach(appointment -> {
            model.addRow(new Object[]{
                appointment.getAppointmentId(),
                appointment.getPatientName(),
                appointment.getDoctorName(),
                appointment.getAppointmentDate(),
                appointment.getReason(),
                appointment.getStatus(),
                appointment.getRoomNumber()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSearchAppointments = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnAddAppointment = new javax.swing.JButton();
        btnDeleteAppointment = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        btnCheckRooms = new javax.swing.JButton();
        btnCheckShedules = new javax.swing.JButton();
        btnSearchAppointments1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSearchAppointments.setBackground(new java.awt.Color(255, 204, 204));
        btnSearchAppointments.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearchAppointments.setText("Search ");
        btnSearchAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAppointmentsActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "AppointmentID", "Patient Name", "Doctor Name ", "Date ", "Reason ", "Status", "Room "
            }
        ));
        jScrollPane1.setViewportView(tblAppointments);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jButton2.setText("Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Doctor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Appointment");

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
                .addContainerGap(17, Short.MAX_VALUE))
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

        btnAddAppointment.setBackground(new java.awt.Color(255, 204, 204));
        btnAddAppointment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddAppointment.setText("Add Appointment");
        btnAddAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAppointmentActionPerformed(evt);
            }
        });

        btnDeleteAppointment.setBackground(new java.awt.Color(255, 204, 204));
        btnDeleteAppointment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeleteAppointment.setText("Delete Appointment");
        btnDeleteAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAppointmentActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Name "));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("Room "));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dotor Name "));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        btnCheckRooms.setBackground(new java.awt.Color(255, 204, 204));
        btnCheckRooms.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCheckRooms.setText("Check Room ");
        btnCheckRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckRoomsActionPerformed(evt);
            }
        });

        btnCheckShedules.setBackground(new java.awt.Color(255, 204, 204));
        btnCheckShedules.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCheckShedules.setText("Check Schedule  ");
        btnCheckShedules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckShedulesActionPerformed(evt);
            }
        });

        btnSearchAppointments1.setBackground(new java.awt.Color(255, 204, 204));
        btnSearchAppointments1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnSearchAppointments1.setText("Appointment ");
        btnSearchAppointments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAppointments1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDeleteAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCheckRooms, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(btnCheckShedules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(144, 144, 144))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchAppointments1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(152, 152, 152)
                                .addComponent(btnSearchAppointments)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearchAppointments)
                    .addComponent(btnSearchAppointments1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddAppointment)
                            .addComponent(btnCheckRooms))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteAppointment)
                            .addComponent(btnCheckShedules))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAppointmentsActionPerformed
        String patientName = jTextField1.getText().trim();
        String doctorName  = jTextField5.getText().trim();
        String roomNumber  = jTextField4.getText().trim();

        AppointmentDAO dao = new AppointmentDAO();
        List<AppointmentDisplay> appointmentList = dao.search(patientName, doctorName, roomNumber);

        DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel(); 
        model.setRowCount(0);

        if (appointmentList == null || appointmentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Không tìm thấy lịch hẹn nào phù hợp.", 
                "Kết quả tìm kiếm", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            appointmentList.forEach(appointment -> {
                model.addRow(new Object[]{
                    appointment.getAppointmentId(),
                    appointment.getPatientName(),
                    appointment.getDoctorName(),
                    appointment.getAppointmentDate(),
                    appointment.getReason(),
                    appointment.getStatus(),
                    appointment.getRoomNumber()
                });
            });
        }
    }//GEN-LAST:event_btnSearchAppointmentsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PatientForm patientForm = new PatientForm();
        patientForm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
  
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        BillForm billForm = new BillForm(); 
        billForm.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnDeleteAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAppointmentActionPerformed
        int selectedRow = tblAppointments.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lịch hẹn để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lịch hẹn này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int appointmentId = Integer.parseInt(tblAppointments.getValueAt(selectedRow, 0).toString());

                // Khởi tạo DAO
                AppointmentDAO appointmentDAO = new AppointmentDAO();

                // Gọi phương thức xóa
                boolean isDeleted = appointmentDAO.deleteAppointment(appointmentId);
                if (isDeleted) {
                    // Xóa hàng khỏi JTable
                    DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Xóa lịch hẹn thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa lịch hẹn thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID lịch hẹn không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                System.err.println("Lỗi khi parse ID lịch hẹn: " + e.getMessage());
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                System.err.println("Lỗi khi xóa lịch hẹn: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteAppointmentActionPerformed

    private void btnAddAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppointmentActionPerformed
        AddAppointment addAppointmentDialog = new AddAppointment(this, true); 
        addAppointmentDialog.setVisible(true);
        Get_Data(); 
    }//GEN-LAST:event_btnAddAppointmentActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void btnCheckRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckRoomsActionPerformed
        // TODO add your handling code here:
        RoomForm roomForm = new RoomForm(conn);
        roomForm.setVisible(true);
    }//GEN-LAST:event_btnCheckRoomsActionPerformed

    private void btnCheckShedulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckShedulesActionPerformed
        // TODO add your handling code here:
        ScheduleForm scheduleForm = new ScheduleForm(conn);
        scheduleForm.setVisible(true);
    }//GEN-LAST:event_btnCheckShedulesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        MedicalRecordForm medicalForm = new MedicalRecordForm();
        medicalForm.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSearchAppointments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAppointments1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchAppointments1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AppointmentForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAppointment;
    private javax.swing.JButton btnCheckRooms;
    private javax.swing.JButton btnCheckShedules;
    private javax.swing.JButton btnDeleteAppointment;
    private javax.swing.JButton btnSearchAppointments;
    private javax.swing.JButton btnSearchAppointments1;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblAppointments;
    // End of variables declaration//GEN-END:variables
}
