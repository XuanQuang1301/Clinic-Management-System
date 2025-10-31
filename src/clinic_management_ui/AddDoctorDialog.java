/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package clinic_management_ui;

import clinic_management_dao.UserDAO;
import clinic_management_dao.Doctor;
import clinic_management_dao.Gender;
import clinic_management_dao.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import clinic_management_dao.DepartmentDAO; 
import clinic_management_dao.DoctorDAO; 
import clinic_management_dao.Department;  
import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;  
import java.util.Map; 

/**
 *
 * @author nguye
 */
public class AddDoctorDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddDoctorDialog.class.getName());
    private Map<String, Integer> departmentMap; 
    private Doctor doctorToUpdate;
 
    public AddDoctorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.doctorToUpdate = null;  
        addDoctor.setText("Add Doctor");
        btnAddDoctor.setText("Add doctor");
        loadDepartmentsToComboBox();
    }
    public AddDoctorDialog(java.awt.Frame parent, boolean modal, Doctor doctorToUpdate) {
        super(parent, modal);
        initComponents();
        this.doctorToUpdate = doctorToUpdate;
        addDoctor.setText("Update Doctor");
        btnAddDoctor.setText("Update");
        loadDepartmentsToComboBox();
        populateFields();
    }
    private void loadDepartmentsToComboBox() {
        departmentMap = new HashMap<>(); 
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> departmentList = departmentDAO.getAllDepartment();
        jComboBox2.removeAllItems();
        for(Department dept: departmentList)
        {
            String departmentName = dept.getDepartmentName();
            int departmentId = dept.getDepartmentId();
            jComboBox2.addItem(departmentName);
            departmentMap.put(departmentName, departmentId); 
        }
    }
    private void populateFields() {
        if (doctorToUpdate != null) {
            txtFullName.setText(doctorToUpdate.getFullName());
            txtBirthday.setText(doctorToUpdate.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            txtEmail.setText(doctorToUpdate.getEmail());
            txtPhoneNumber.setText(doctorToUpdate.getPhoneNumber());
            txtSpecialization.setText(doctorToUpdate.getSpecialization());
            jComboBox1.setSelectedItem(doctorToUpdate.getGender() == Gender.MALE ? "Male" : "Female");
            for (int i = 0; i < jComboBox2.getItemCount(); i++) {
                String departmentName = (String) jComboBox2.getItemAt(i);
                if (departmentMap.get(departmentName) == doctorToUpdate.getDepartmentId()) {
                    jComboBox2.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FullName = new javax.swing.JLabel();
        Birthday = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        LabelPhoneNumber = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        addDoctor = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        Department = new javax.swing.JLabel();
        Specialization = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        LabelGender = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        FullName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        FullName.setText("FullName:");

        Birthday.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Birthday.setText("Birthday:");

        Email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email.setText("Email:");

        LabelPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        LabelPhoneNumber.setText("PhoneNumber");

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAddDoctor.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddDoctor.setText("Add doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        addDoctor.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addDoctor.setText("Add Doctor");

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        Department.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Department.setText("Department:");

        Specialization.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Specialization.setText("Specialization:");

        txtSpecialization.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtBirthday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdayActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        LabelGender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        LabelGender.setText("Gender:");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Internal Medicine", "Obstetrics and Gynecology", "Gynecology", "Surgery", "Dermatology", "Radiology", "Anesthesiology", "Traditional Medicine", "Public Health", "Odonto-Stomatology" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Specialization)
                            .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jComboBox2, txtBirthday, txtEmail, txtFullName, txtPhoneNumber, txtSpecialization});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(addDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FullName))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelGender))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPhoneNumber))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Department))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Specialization)
                    .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDoctor)
                    .addComponent(btnCancel))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jComboBox2, txtBirthday, txtEmail, txtFullName, txtPhoneNumber, txtSpecialization});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed

        String fullName = txtFullName.getText();
String birthdayStr = txtBirthday.getText();
String email = txtEmail.getText();
String phoneNumber = txtPhoneNumber.getText();
String selectedDepartmentName = (String) jComboBox2.getSelectedItem();
String specialization = txtSpecialization.getText();
String genderId = (String) jComboBox1.getSelectedItem();

// Lấy ID khoa từ map (nếu có)
int departmentId = departmentMap.getOrDefault(selectedDepartmentName, 0);

// Xác định giới tính
Gender gender = "Male".equalsIgnoreCase(genderId) ? Gender.MALE : Gender.FEMALE;

// Parse ngày sinh (nếu để trống hoặc sai format thì dùng ngày hiện tại)
LocalDate birthday;
try {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    birthday = LocalDate.parse(birthdayStr, formatter);
} catch (Exception e) {
    birthday = LocalDate.now();
}

DoctorDAO doctorDAO = new DoctorDAO();
boolean success = false;

if (doctorToUpdate == null) {
    // Thêm mới
    Doctor newDoctor = new Doctor();
    newDoctor.setFullName(fullName);
    newDoctor.setDateOfBirth(birthday);
    newDoctor.setGender(gender);
    newDoctor.setEmail(email);
    newDoctor.setPhoneNumber(phoneNumber);
    newDoctor.setDepartmentId(departmentId);
    newDoctor.setSpecialization(specialization);

            try {
                success = doctorDAO.add(newDoctor);
            } catch (SQLException ex) {
                System.getLogger(AddDoctorDialog.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
    JOptionPane.showMessageDialog(this, success ? "Thêm bác sĩ thành công!" : "Thêm bác sĩ thất bại.");
} else {
    // Cập nhật
    doctorToUpdate.setFullName(fullName);
    doctorToUpdate.setDateOfBirth(birthday);
    doctorToUpdate.setGender(gender);
    doctorToUpdate.setEmail(email);
    doctorToUpdate.setPhoneNumber(phoneNumber);
    doctorToUpdate.setDepartmentId(departmentId);
    doctorToUpdate.setSpecialization(specialization);

            try {
                success = doctorDAO.updateDoctor(doctorToUpdate);
            } catch (SQLException ex) {
                System.getLogger(AddDoctorDialog.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
    JOptionPane.showMessageDialog(this, success ? "Cập nhật thông tin thành công!" : "Cập nhật thất bại.");
}

// Refresh lại bảng nếu form cha là DoctorForm
if (success && this.getOwner() instanceof DoctorForm) {
    ((DoctorForm) this.getOwner()).loadDoctorsToTable();
}

// Đóng form sau khi lưu
if (success) {
    this.dispose();
}

//        String fullName = txtFullName.getText().trim();
//        String birthdayStr = txtBirthday.getText().trim();
//        String email = txtEmail.getText().trim();
//        String phoneNumber = txtPhoneNumber.getText().trim();
//        String selectedDepartmentName = (String) jComboBox2.getSelectedItem();
//        String specialization = txtSpecialization.getText().trim();
//        String genderId = (String) jComboBox1.getSelectedItem();
//        if(fullName.isEmpty() || birthdayStr.isEmpty() || email.isEmpty() || selectedDepartmentName.isEmpty())
//        {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ các trường.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
////        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
////        if (!email.matches(emailRegex)) {
////            JOptionPane.showMessageDialog(this, "Định dạng email không hợp lệ. Vui lòng kiểm tra lại.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
////            return; 
////        }
////        String phoneRegex = "^0\\d{9}$";
////        if (!phoneNumber.matches(phoneRegex)) {
////            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.\nPhải có 10 chữ số và bắt đầu bằng số 0.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
////            return; 
////        }
////        try {
////            int departmentId = departmentMap.get(selectedDepartmentName);
////            Gender gender;
////            if("Male".equalsIgnoreCase(genderId))
////            {
////                gender = Gender.MALE;
////            }
////            else {
////            gender = Gender.FEMALE;
////            }
////            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////            LocalDate birthday = LocalDate.parse(birthdayStr, formatter);
////            DoctorDAO doctorDAO = new DoctorDAO();
////            boolean success = false;
////            if (doctorToUpdate == null) 
////            {
////                Doctor newDoctor = new Doctor();
////                newDoctor.setFullName(fullName);
////                newDoctor.setDateOfBirth(birthday); 
////                newDoctor.setGender(gender); 
////                newDoctor.setEmail(email);
////                newDoctor.setPhoneNumber(phoneNumber); 
////                newDoctor.setDepartmentId(departmentId);
////                newDoctor.setSpecialization(specialization);
////                success = doctorDAO.add(newDoctor);
////                if (success) {
////                    JOptionPane.showMessageDialog(this, "Thêm bác sĩ thành công!");
////                   
////                } else {
////                    JOptionPane.showMessageDialog(this, "Thêm bác sĩ thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
////                }
////            }
////            else { 
////                doctorToUpdate.setFullName(fullName);
////                doctorToUpdate.setDateOfBirth(birthday);
////                doctorToUpdate.setGender(gender);
////                doctorToUpdate.setEmail(email);
////                doctorToUpdate.setPhoneNumber(phoneNumber);
////                doctorToUpdate.setDepartmentId(departmentId);
////                doctorToUpdate.setSpecialization(specialization);
////                
////                success = doctorDAO.updateDoctor(doctorToUpdate);
////                if (success) {
////                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
////         
////                } else {
////                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
////                }
////            }
////            if (success) {
////            if (this.getOwner() instanceof DoctorForm) {
////                ((DoctorForm) this.getOwner()).loadDoctorsToTable();
////            }
////            this.dispose(); 
////            }
////        }
////        catch (java.time.format.DateTimeParseException e) {
////        JOptionPane.showMessageDialog(this, "Định dạng ngày sinh không hợp lệ (dd/MM/yyyy).", "Lỗi", JOptionPane.ERROR_MESSAGE);
////        e.printStackTrace();
////        }
////        catch(Exception e)
////        {
////            e.printStackTrace();
////        }
//       
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddDoctorDialog dialog = new AddDoctorDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Birthday;
    private javax.swing.JLabel Department;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel FullName;
    private javax.swing.JLabel LabelGender;
    private javax.swing.JLabel LabelPhoneNumber;
    private javax.swing.JLabel Specialization;
    private javax.swing.JLabel addDoctor;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSpecialization;
    // End of variables declaration//GEN-END:variables
}
