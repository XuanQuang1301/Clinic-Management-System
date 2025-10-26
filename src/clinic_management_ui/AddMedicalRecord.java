package clinic_management_ui;

import clinic_management_dao.*;
import javax.swing.*;
import java.awt.*;

public class AddMedicalRecord extends JDialog {
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    
    private JComboBox<Appointment> appointmentComboBox;
    
    private JTextArea diagnosisTextArea, treatmentTextArea;
    private JButton saveButton, cancelButton;

    
    private final Patient currentPatient;
    private boolean succeeded = false; 

    public AddMedicalRecord(Dialog owner, Patient patient) {
        super(owner, "Add New Medical Record", true);
        this.currentPatient = patient;

        setSize(900, 600);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));
        
      
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(new JLabel("For Appointment:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; appointmentComboBox = new JComboBox<>(); formPanel.add(appointmentComboBox, gbc);
        
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.NORTHWEST; formPanel.add(new JLabel("Detailed Diagnosis:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        diagnosisTextArea = new JTextArea(4, 20); formPanel.add(new JScrollPane(diagnosisTextArea), gbc);
        
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.NORTHWEST; formPanel.add(new JLabel("Treatment Method:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        treatmentTextArea = new JTextArea(4, 20); formPanel.add(new JScrollPane(treatmentTextArea), gbc);
        
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        saveButton.addActionListener(e -> saveMedicalRecord());
        cancelButton.addActionListener(e -> dispose());

        loadComboBoxData();
    }
    
    private void loadComboBoxData() {
        appointmentDAO.getAppointmentsByPatientId(currentPatient.getId()).forEach(appointmentComboBox::addItem);
        
    }

    private void saveMedicalRecord() {
        Appointment selectedApp = (Appointment) appointmentComboBox.getSelectedItem();
        
        if (selectedApp == null) {
            JOptionPane.showMessageDialog(this, "Please select an appointment.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalRecord record = new MedicalRecord();
        record.setAppointmentId(selectedApp.getAppointmentId());
        record.setPatientId(currentPatient.getId());
        record.setDoctorId(selectedApp.getDoctorId());
        
        
        
        record.setDiagnosis(diagnosisTextArea.getText());
        record.setTreatment(treatmentTextArea.getText());

        if (medicalRecordDAO.addMedicalRecord(record)) {
            JOptionPane.showMessageDialog(this, "Medical record added successfully!");
          
            succeeded = true;
            dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add medical record. Please check database connection.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    public boolean isSucceeded() {
        return succeeded;
    }
}
