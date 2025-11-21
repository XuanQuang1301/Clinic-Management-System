package clinic_management_ui;

import clinic_management_dao.BloodGroup;
import clinic_management_dao.Patient;
import clinic_management_dao.PatientDAO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AddPatient extends javax.swing.JFrame {
    private Patient currentPatient = null; 
    private final PatientDAO patientDAO = new PatientDAO();
    private static final DateTimeFormatter UI_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public AddPatient() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
    private void Reset() {
        txtFullname.setText("");
        txtBirthday.setText("");
        txtAddress.setText("");
        txtContactNo.setText("");
        txtEmail.setText("");
        txtInsurance.setText("");
        cmbBloodGroup.setSelectedIndex(-1); 
        cmbGender.setSelectedIndex(-1);
        btnSave.setEnabled(true);
}
    
    public void setPatientForUpdate(Patient patientToUpdate) {
        this.currentPatient = patientToUpdate;
        this.setTitle("Cập nhật bệnh nhân ID: " + patientToUpdate.getId());
        loadPatientData(patientToUpdate); 
    }

    private void loadPatientData(Patient p) {
        txtFullname.setText(p.getFullName());
        txtAddress.setText(p.getAddress());
        txtContactNo.setText(p.getPhoneNumber());
        txtEmail.setText(p.getEmail());
        txtInsurance.setText(p.getInsuranceNumber());

        if (p.getDateOfBirth() != null) {
             txtBirthday.setText(p.getDateOfBirth().format(UI_DATE_FORMATTER)); 
        } else {
             txtBirthday.setText("");
        }

        String genderStr = p.getGender();
        if (genderStr != null) {
             cmbGender.setSelectedItem(genderStr);
        }

        if (p.getBloodGroup() != null) {
            cmbBloodGroup.setSelectedItem(p.getBloodGroup().name()); 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtInsurance = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbBloodGroup = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Fullname");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contact No.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Insurance Number");

        txtInsurance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInsuranceKeyTyped(evt);
            }
        });

        cmbBloodGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O", "A", "B", "AB" }));
        cmbBloodGroup.setSelectedIndex(-1);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Gender");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cmbGender.setSelectedIndex(-1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Blood");

        txtContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNoActionPerformed(evt);
            }
        });
        txtContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactNoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Birthday");

        txtBirthday.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdayActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 204, 204));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress, txtBirthday, txtContactNo, txtEmail, txtFullname, txtInsurance});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbBloodGroup, cmbGender, txtAddress, txtBirthday, txtContactNo, txtEmail, txtFullname, txtInsurance});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInsuranceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInsuranceKeyTyped
        char c = evt.getKeyChar();
        if (txtInsurance.getText().length() >= 11 &&
            Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume(); 
            return;
        }
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtInsuranceKeyTyped

    private void txtContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNoActionPerformed

    private void txtContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactNoKeyTyped
        char c=evt.getKeyChar();
        // chi nhan 10 so
        if (txtContactNo.getText().length() >= 10 &&
            Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            return;
        }
        // chi nhan so, khoang trang, xoa
        if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtContactNoKeyTyped

    private void txtBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdayActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String fullname = txtFullname.getText().trim();
        String gender = cmbGender.getSelectedItem() != null ? cmbGender.getSelectedItem().toString() : null;
        String birthday = txtBirthday.getText().trim();
        String address = txtAddress.getText().trim();
        String contact = txtContactNo.getText().trim();
        String blood = cmbBloodGroup.getSelectedItem() != null ? cmbBloodGroup.getSelectedItem().toString() : null;
        String insurance = txtInsurance.getText().trim();
        String email = txtEmail.getText().trim().toLowerCase();

        // 1. Kiểm tra Email
        String regex = "^[a-z0-9._]+@gmail\\.com$";
        if (!email.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Invalid email address format (@gmail.com required).");
            return;
        }

        // 2. Chuyển đổi Ngày sinh
        LocalDate dob = null;
        if (!birthday.isEmpty()) {
            try {
                String normalizedStr = birthday.replace('/', '-');
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dob = LocalDate.parse(normalizedStr, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid birthday format. Please use dd/MM/yyyy.");
                return;
            }
        }

        // 3. Chuyển đổi Nhóm máu
        BloodGroup bg = null;
        if (blood != null && !blood.isEmpty()) {
            try {
                bg = BloodGroup.valueOf(blood.trim().toUpperCase());
            } catch (IllegalArgumentException e_bg) {
                JOptionPane.showMessageDialog(this, "Invalid blood group value: " + blood);
                return;
            }
        }

        // 4. Tạo đối tượng Patient (Xác định ID)
        int id = (currentPatient != null) ? currentPatient.getId() : 0; // Lấy ID cũ nếu là Update

        Patient finalPatient = new Patient(
            id, 
            fullname,
            gender,
            contact, 
            dob,
            address,
            bg,
            email,
            insurance
        );

        // 5. GỌI DAO: PHÂN BIỆT INSERT và UPDATE
        boolean success = false;
        String actionType = (currentPatient == null) ? "add" : "update";

        if (currentPatient == null) {
            success = patientDAO.insertPatient(finalPatient); 
        } else {
            success = patientDAO.updatePatient(finalPatient); 
        }

        // 6. Xử lý kết quả
        if (success) {
            JOptionPane.showMessageDialog(this, "Patient " + actionType + " successfully!");
            btnSave.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error " + actionType + " patient!");
        }
        
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AddPatient().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSave;
    public javax.swing.JComboBox cmbBloodGroup;
    public javax.swing.JComboBox cmbGender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtAddress;
    public javax.swing.JTextField txtBirthday;
    public javax.swing.JTextField txtContactNo;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFullname;
    public javax.swing.JTextField txtInsurance;
    // End of variables declaration//GEN-END:variables
}