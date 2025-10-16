package clinic_management_ui;

import clinic_management_dao.*;
import javax.swing.*;
import java.awt.*;

public class AddMedicalRecord extends JDialog {

    // DAO
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private final DiseaseDAO diseaseDAO = new DiseaseDAO();
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    // UI Components
    private JComboBox<Appointment> appointmentComboBox;
    private JComboBox<Disease> diseaseComboBox;
    private JTextArea diagnosisTextArea, treatmentTextArea;
    private JButton saveButton, cancelButton;

    // Data
    private final Patient currentPatient;
    private boolean succeeded = false; // Biến cờ để báo cho cửa sổ cha biết đã thêm thành công

    public AddMedicalRecord(Dialog owner, Patient patient) {
        super(owner, "Add New Medical Record", true);
        this.currentPatient = patient;

        setSize(600, 400);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));
        
        // --- Giao diện ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(new JLabel("For Appointment:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; appointmentComboBox = new JComboBox<>(); formPanel.add(appointmentComboBox, gbc);
        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(new JLabel("Diagnosed Disease:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; diseaseComboBox = new JComboBox<>(); formPanel.add(diseaseComboBox, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.NORTHWEST; formPanel.add(new JLabel("Detailed Diagnosis:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        diagnosisTextArea = new JTextArea(4, 20); formPanel.add(new JScrollPane(diagnosisTextArea), gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.NORTHWEST; formPanel.add(new JLabel("Treatment Method:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        treatmentTextArea = new JTextArea(4, 20); formPanel.add(new JScrollPane(treatmentTextArea), gbc);
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Sự kiện ---
        saveButton.addActionListener(e -> saveMedicalRecord());
        cancelButton.addActionListener(e -> dispose());

        loadComboBoxData();
    }
    
    private void loadComboBoxData() {
        appointmentDAO.getAppointmentsByPatientId(currentPatient.getId()).forEach(appointmentComboBox::addItem);
        diseaseComboBox.addItem(null);
        diseaseDAO.getAllDiseases().forEach(diseaseComboBox::addItem);
    }

    private void saveMedicalRecord() {
        Appointment selectedApp = (Appointment) appointmentComboBox.getSelectedItem();
        // --- Kiểm tra dữ liệu đầu vào ---
        if (selectedApp == null) {
            JOptionPane.showMessageDialog(this, "Please select an appointment.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalRecord record = new MedicalRecord();
        record.setAppointmentId(selectedApp.getAppointmentId());
        record.setPatientId(currentPatient.getId());
        record.setDoctorId(selectedApp.getDoctorId());
        
        Disease selectedDisease = (Disease) diseaseComboBox.getSelectedItem();
        if (selectedDisease != null) {
            record.setDiseaseId(selectedDisease.getDiseaseId());
        }
        
        record.setDiagnosis(diagnosisTextArea.getText());
        record.setTreatment(treatmentTextArea.getText());

        if (medicalRecordDAO.addMedicalRecord(record)) {
            JOptionPane.showMessageDialog(this, "Medical record added successfully!");
            // ---Dùng biến cờ báo hiệu thành công ---
            succeeded = true;
            dispose(); // Đóng cửa sổ
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add medical record. Please check database connection.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- Thêm hàm để cửa sổ cha kiểm tra ---
    public boolean isSucceeded() {
        return succeeded;
    }
}