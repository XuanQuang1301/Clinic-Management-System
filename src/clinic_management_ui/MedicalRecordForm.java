package clinic_management_ui;

import clinic_management_dao.MedicalRecordDAO;
import clinic_management_dao.MedicalRecordDisplay;
import clinic_management_dao.Prescription;
import clinic_management_dao.PrescriptionDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class MedicalRecordForm extends JFrame {

    private final MedicalRecordDAO recordDAO = new MedicalRecordDAO();
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private Integer currentlyEditingPrescriptionId = null;

    private JTextField txtPatientName, txtDoctorName;
    private JButton btnSearch, btnDeleteRecord, btnEditRecord;
    private JTable tblRecords;
    private DefaultTableModel recordTableModel;
    private JPanel prescriptionPanel;
    private JTable tblPrescriptions;
    private DefaultTableModel prescriptionTableModel;
    private JTextField txtMedicineName, txtDosage, txtQuantity;
    private JTextArea txtInstructions;
    private JButton btnAddOrUpdate, btnNew, btnDeletePrescription;
    private JPanel navPanel;

    public MedicalRecordForm() {
        super("Clinic Management - Medical Records");
        initComponents();
        loadAllRecords(); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        createNavigationPanel();
        mainPanel.add(navPanel, BorderLayout.WEST);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createMedicalRecordPanel(), createPrescriptionPanel());
        splitPane.setResizeWeight(0.55);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnSaveWindow = new JButton("Save & Close");
        JButton btnCancelWindow = new JButton("Cancel");
        btnSaveWindow.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancelWindow.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bottomButtonPanel.add(btnSaveWindow);
        bottomButtonPanel.add(btnCancelWindow);
        mainPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
        btnSaveWindow.addActionListener(e -> backToMainPage());
        btnCancelWindow.addActionListener(e -> backToMainPage());
        this.setContentPane(mainPanel);
    }

    private void backToMainPage() {
        new AppointmentForm().setVisible(true);
        this.dispose();
    }

    private JPanel createMedicalRecordPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Medical Records Management"));
        JPanel searchPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel fieldsPanel = new JPanel(new FlowLayout());
        txtPatientName = new JTextField(15);
        txtPatientName.setBorder(BorderFactory.createTitledBorder("Patient Name"));
        txtDoctorName = new JTextField(15);
        txtDoctorName.setBorder(BorderFactory.createTitledBorder("Doctor Name"));
        fieldsPanel.add(txtPatientName);
        fieldsPanel.add(txtDoctorName);
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        btnSearch = new JButton("Search");
        btnEditRecord = new JButton("Edit Selected Record");
        btnDeleteRecord = new JButton("Delete Selected Record");
        buttonsPanel.add(btnSearch);
        buttonsPanel.add(btnEditRecord);
        buttonsPanel.add(btnDeleteRecord);
        searchPanel.add(fieldsPanel);
        searchPanel.add(buttonsPanel);
        panel.add(searchPanel, BorderLayout.NORTH);
        recordTableModel = new DefaultTableModel(new String[]{"ID", "Patient", "Doctor", "Date", "Diagnosis"}, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        tblRecords = new JTable(recordTableModel);
        tblRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(tblRecords), BorderLayout.CENTER);
        tblRecords.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updatePrescriptionView();
            }
        });
        btnSearch.addActionListener(evt -> searchRecords());
        btnEditRecord.addActionListener(evt -> editSelectedRecord());
        btnDeleteRecord.addActionListener(evt -> deleteSelectedRecord());
        return panel;
    }

    private JPanel createPrescriptionPanel() {
        prescriptionPanel = new JPanel(new BorderLayout(10, 10));
        prescriptionPanel.setBorder(BorderFactory.createTitledBorder("Prescriptions for Selected Record"));
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        formPanel.add(new JLabel("Medicine Name:"));
        txtMedicineName = new JTextField();
        formPanel.add(txtMedicineName);
        formPanel.add(new JLabel("Dosage:"));
        txtDosage = new JTextField();
        formPanel.add(txtDosage);
        formPanel.add(new JLabel("Quantity:"));
        txtQuantity = new JTextField();
        formPanel.add(txtQuantity);
        formPanel.add(new JLabel("Instructions:"));
        txtInstructions = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(txtInstructions));
        JPanel formContainer = new JPanel(new BorderLayout());
        formContainer.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnAddOrUpdate = new JButton("Add / Update");
        btnNew = new JButton("New");
        btnDeletePrescription = new JButton("Delete");

        buttonPanel.add(btnAddOrUpdate);
        buttonPanel.add(btnNew);
        buttonPanel.add(btnDeletePrescription);

        formContainer.add(buttonPanel, BorderLayout.SOUTH);
        prescriptionPanel.add(formContainer, BorderLayout.NORTH);

        prescriptionTableModel = new DefaultTableModel(new String[]{"ID", "Medicine", "Dosage", "Qty"}, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        tblPrescriptions = new JTable(prescriptionTableModel);
        prescriptionPanel.add(new JScrollPane(tblPrescriptions), BorderLayout.CENTER);

        tblPrescriptions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblPrescriptions.getSelectedRow();
                if (selectedRow != -1) {
                    showPrescriptionDetails(selectedRow);
                }
            }
        });

        btnAddOrUpdate.addActionListener(evt -> addOrUpdatePrescription());
        btnNew.addActionListener(evt -> clearPrescriptionForm());
        btnDeletePrescription.addActionListener(evt -> deleteSelectedPrescription());

        setPrescriptionPanelEnabled(false);
        return prescriptionPanel;
    }
    private void loadAllRecords() {
        btnSearch.setEnabled(false);
        btnEditRecord.setEnabled(false);
        btnDeleteRecord.setEnabled(false);


        SwingWorker<List<MedicalRecordDisplay>, Void> worker = new SwingWorker<List<MedicalRecordDisplay>, Void>() {
            
            @Override
            protected List<MedicalRecordDisplay> doInBackground() throws Exception {
                recordDAO.synchronizeMedicalRecords();
                return recordDAO.getAllRecordsWithDetails();
            }

            @Override
            protected void done() {
                try {
                    
                    List<MedicalRecordDisplay> list = get();
                    recordTableModel.setRowCount(0);
                    if (list != null) {
                        for (MedicalRecordDisplay record : list) {
                            recordTableModel.addRow(new Object[]{
                                record.getRecordId(), record.getPatientName(), record.getDoctorName(),
                                record.getAppointmentDate(), record.getDiagnosis()
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(MedicalRecordForm.this,
                            "Error loading data: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    
                    btnSearch.setEnabled(true);
                    btnEditRecord.setEnabled(true);
                    btnDeleteRecord.setEnabled(true);
                }
            }
        };

        
        worker.execute();
    }

    private void createNavigationPanel() {
        navPanel = new JPanel(new GridBagLayout());
        navPanel.setBackground(new Color(255, 204, 204));
        navPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        navPanel.setPreferredSize(new Dimension(180, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(12, 0, 12, 0);

        JLabel title = new JLabel("Clinic Management");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        navPanel.add(title, gbc);

        gbc.insets = new Insets(12, 30, 12, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weighty = 0;

        JButton btnPatient = new JButton("Patient");
        JButton btnDoctor = new JButton("Doctor");
        JButton btnDepartment = new JButton("Department");
        JButton btnAppointment = new JButton("Appointment");
        JButton btnMedicalRecord = new JButton("Medical Record");
        JButton btnBill = new JButton("Bill");

        JButton[] navButtons = {btnPatient, btnDoctor, btnDepartment, btnAppointment, btnMedicalRecord, btnBill};

        for (JButton btn : navButtons) {
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(140, 30));
            navPanel.add(btn, gbc);
        }

        gbc.weighty = 1.0;
        navPanel.add(new JLabel(""), gbc);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFocusPainted(false);
        btnLogout.setPreferredSize(new Dimension(140, 30));
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.WEST;
        navPanel.add(btnLogout, gbc);

        btnDoctor.addActionListener(e -> { new DoctorForm().setVisible(true); });
        btnDepartment.addActionListener(e -> { new DepartmentForm().setVisible(true); });
        btnBill.addActionListener(e -> { new BillForm().setVisible(true); });
        btnPatient.addActionListener(e -> { new PatientForm().setVisible(true); });
        btnAppointment.addActionListener(e -> { new AppointmentForm().setVisible(true); });
        
        
        btnMedicalRecord.addActionListener(e -> loadAllRecords());
    }

  
    
    private void showPrescriptionDetails(int row) {
        currentlyEditingPrescriptionId = (Integer) tblPrescriptions.getValueAt(row, 0);
        txtMedicineName.setText((String) tblPrescriptions.getValueAt(row, 1));
        txtDosage.setText((String) tblPrescriptions.getValueAt(row, 2));
        txtQuantity.setText(String.valueOf(tblPrescriptions.getValueAt(row, 3)));
        Prescription p = prescriptionDAO.getPrescriptionById(currentlyEditingPrescriptionId);
        if (p != null) txtInstructions.setText(p.getInstructions());
    }

    private void addOrUpdatePrescription() {
        int selectedRecordRow = tblRecords.getSelectedRow();
        if (selectedRecordRow == -1) { JOptionPane.showMessageDialog(this, "Please select a medical record first.", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        int recordId = (int) tblRecords.getValueAt(selectedRecordRow, 0);
        String medicineName = txtMedicineName.getText().trim();
        String dosage = txtDosage.getText().trim();
        String instructions = txtInstructions.getText().trim();
        String quantityStr = txtQuantity.getText().trim();
        if (medicineName.isEmpty() || dosage.isEmpty() || quantityStr.isEmpty()) { JOptionPane.showMessageDialog(this, "Medicine Name, Dosage, and Quantity are required.", "Validation Error", JOptionPane.WARNING_MESSAGE); return; }
        int quantity;
        try { quantity = Integer.parseInt(quantityStr); } catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Quantity must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE); return; }
        Prescription p = new Prescription();
        p.setRecordId(recordId);
        p.setMedicineName(medicineName);
        p.setDosage(dosage);
        p.setQuantity(quantity);
        p.setInstructions(instructions);

        boolean success;
        String action;
        if (currentlyEditingPrescriptionId == null) {
            success = prescriptionDAO.addPrescription(p);
            action = "added";
        } else {
            p.setPrescriptionId(currentlyEditingPrescriptionId);
            success = prescriptionDAO.updatePrescription(p);
            action = "updated";
        }

        if (success) {
            JOptionPane.showMessageDialog(this, "Prescription " + action + " successfully.");
            loadPrescriptionsForRecord(recordId);
            clearPrescriptionForm();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save prescription.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearPrescriptionForm() {
        txtMedicineName.setText("");
        txtDosage.setText("");
        txtQuantity.setText("");
        txtInstructions.setText("");
        currentlyEditingPrescriptionId = null;
        tblPrescriptions.clearSelection();
    }
    
    private void editSelectedRecord() {
        int selectedRow = tblRecords.getSelectedRow();
        if (selectedRow == -1) { JOptionPane.showMessageDialog(this, "Please select a record to edit.", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        int recordId = (int) tblRecords.getValueAt(selectedRow, 0);
        String currentDiagnosis = (String) tblRecords.getValueAt(selectedRow, 4);
        String newDiagnosis = JOptionPane.showInputDialog(this, "Enter new diagnosis:", currentDiagnosis);
        if (newDiagnosis != null && !newDiagnosis.trim().isEmpty() && !newDiagnosis.equals(currentDiagnosis)) {
            if (recordDAO.updateMedicalRecordDiagnosis(recordId, newDiagnosis.trim())) {
                JOptionPane.showMessageDialog(this, "Diagnosis updated successfully.");
                loadAllRecords();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update diagnosis.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchRecords() {
        String patientName = txtPatientName.getText().trim();
        String doctorName = txtDoctorName.getText().trim();
        List<MedicalRecordDisplay> list = recordDAO.searchRecords(patientName, doctorName);
        recordTableModel.setRowCount(0);
        if (list != null) {
            for (MedicalRecordDisplay record : list) {
                recordTableModel.addRow(new Object[]{
                    record.getRecordId(), record.getPatientName(), record.getDoctorName(),
                    record.getAppointmentDate(), record.getDiagnosis()
                });
            }
        }
    }

    private void deleteSelectedRecord() {
        int selectedRow = tblRecords.getSelectedRow();
        if (selectedRow == -1) { JOptionPane.showMessageDialog(this, "Please select a record to delete.", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        int recordId = (int) tblRecords.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete record ID: " + recordId + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (recordDAO.deleteMedicalRecord(recordId)) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                loadAllRecords();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete record.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updatePrescriptionView() {
        int selectedRow = tblRecords.getSelectedRow();
        if (selectedRow != -1) {
            setPrescriptionPanelEnabled(true);
            int recordId = (int) tblRecords.getValueAt(selectedRow, 0);
            loadPrescriptionsForRecord(recordId);
        } else {
            setPrescriptionPanelEnabled(false);
            prescriptionTableModel.setRowCount(0);
        }
        clearPrescriptionForm();
    }

    private void loadPrescriptionsForRecord(int recordId) {
        List<Prescription> list = prescriptionDAO.getPrescriptionsByRecordId(recordId);
        prescriptionTableModel.setRowCount(0);
        if (list != null) {
            for (Prescription p : list) {
                prescriptionTableModel.addRow(new Object[]{p.getPrescriptionId(), p.getMedicineName(), p.getDosage(), p.getQuantity()});
            }
            if (!list.isEmpty()) {
                tblPrescriptions.setRowSelectionInterval(0, 0);
                showPrescriptionDetails(0);
            }
        }
    }

    private void deleteSelectedPrescription() {
        int selectedPrescriptionRow = tblPrescriptions.getSelectedRow();
        if (selectedPrescriptionRow == -1) { JOptionPane.showMessageDialog(this, "Please select a prescription to delete.", "Warning", JOptionPane.WARNING_MESSAGE); return; }
        int prescriptionId = (int) tblPrescriptions.getValueAt(selectedPrescriptionRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this medicine from the prescription?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (prescriptionDAO.deletePrescription(prescriptionId)) {
                JOptionPane.showMessageDialog(this, "Prescription deleted successfully.");
                updatePrescriptionView();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete prescription.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void setPrescriptionPanelEnabled(boolean enabled) {
        for (Component component : prescriptionPanel.getComponents()) {
            if (component instanceof JPanel) {
                for (Component subComponent : ((JPanel) component).getComponents()) {
                    subComponent.setEnabled(enabled);
                    if (subComponent instanceof JScrollPane) {
                        ((JScrollPane) subComponent).getViewport().getView().setEnabled(enabled);
                    }
                }
            }
            component.setEnabled(enabled);
        }
        tblPrescriptions.setEnabled(enabled);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MedicalRecordForm().setVisible(true);
        });
    }
}
