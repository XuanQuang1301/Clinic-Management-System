package clinic_management_ui;
import clinic_management_dao.AppointmentDAO;
import clinic_management_dao.Appointment;
import clinic_management_dao.PatientDAO;
import clinic_management_dao.DoctorDAO;
import clinic_management_dao.RoomDAO;
import clinic_management_dao.Patient;
import clinic_management_dao.Doctor;
import clinic_management_dao.Room;
import java.util.*; 
import java.sql.*; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class AddAppointment extends javax.swing.JDialog {
    private Connection conn;

    public AddAppointment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        loadPatients();
        loadDoctors();
        loadRooms();
    }
    public AddAppointment(Connection conn) {
        this.conn = conn; 
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        loadPatients();
        loadDoctors();
        loadRooms();
    }
    
    private void loadPatients() {
    try {
        PatientDAO dao = new PatientDAO(conn);
        List<Patient> patients = dao.getAllPatients();
        cbPatient.removeAllItems();
        for (Patient p : patients) {
            cbPatient.addItem(p.getId() + " - " + p.getFullName());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi load bệnh nhân: " + e.getMessage());
        }
    }

    private void loadDoctors() {
        try {
            DoctorDAO dao = new DoctorDAO(conn);
            List<Doctor> doctors = dao.getAllDoctors();
            cbDoctors.removeAllItems();
            for (Doctor d : doctors) {
                String depName = dao.getDepartmentNameById(d.getDepartmentId()); 
                cbDoctors.addItem(d.getDoctorId() + " - " + d.getFullName() + " - " + depName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load bác sĩ: " + e.getMessage());
        }
    }
    private void loadRooms() {
        try {
            RoomDAO dao = new RoomDAO(conn);
            List<Room> rooms = dao.getAllRooms();
            cbRooms1.removeAllItems();
            for (Room r : rooms) {
                cbRooms1.addItem(r.getRoomId() + " - " + r.getRoomNumber() + " - " + r.getDepartmentName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load phòng: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbRooms1 = new javax.swing.JComboBox<>();
        txtReasons = new javax.swing.JTextField();
        txtDates = new javax.swing.JTextField();
        cbDoctors = new javax.swing.JComboBox<>();
        cbPatient = new javax.swing.JComboBox<>();

        setSize(new java.awt.Dimension(480, 500));

        btnSave.setBackground(new java.awt.Color(255, 204, 204));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setText("Save ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 204, 204));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancel.setText("Cancel ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 228, 225));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("Book a medical appointment");
        jButton5.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Patient Name:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Doctor Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Date:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Reason:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Room:");

        cbRooms1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbRooms1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRooms1ActionPerformed(evt);
            }
        });

        txtReasons.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtReasons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReasonsActionPerformed(evt);
            }
        });

        txtDates.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatesActionPerformed(evt);
            }
        });

        cbDoctors.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbPatient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(txtDates))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(cbRooms1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(txtReasons, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(75, 75, 75)
                        .addComponent(btnCancel)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRooms1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReasons, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDates, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
        String patientStr = (String) cbPatient.getSelectedItem();
        String doctorStr = (String) cbDoctors.getSelectedItem();
        String roomStr   = (String) cbRooms1.getSelectedItem();
        
        int patientId = Integer.parseInt(patientStr.split(" - ")[0]);
        int doctorId  = Integer.parseInt(doctorStr.split(" - ")[0]);
        int roomId    = Integer.parseInt(roomStr.split(" - ")[0]);
        
        String date = txtDates.getText();
        String reason = txtReasons.getText();
        SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted = outFmt.format(inFmt.parse(txtDates.getText().trim()));

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setRoomId(roomId);
        appointment.setAppointmentDate(Timestamp.valueOf(formatted));
        appointment.setReason(reason);
        appointment.setStatus("Pending");

        AppointmentDAO dao = new AppointmentDAO(conn);
        dao.insert(appointment);

        JOptionPane.showMessageDialog(this, "Đặt lịch thành công!");
        this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi lưu lịch hẹn!");
            JOptionPane.showMessageDialog(this, "Lỗi lưu lịch hẹn: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatesActionPerformed

    private void txtReasonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReasonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReasonsActionPerformed

    private void cbRooms1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRooms1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRooms1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Connection conn = Connect.ConnectDB();
        java.awt.EventQueue.invokeLater(() -> new AddAppointment(conn).setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbDoctors;
    private javax.swing.JComboBox<String> cbPatient;
    private javax.swing.JComboBox<String> cbRooms1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDates;
    private javax.swing.JTextField txtReasons;
    // End of variables declaration//GEN-END:variables
}
