package clinic_management_dao;

public class Disease {
    // ... các thuộc tính và constructor của bạn giữ nguyên ...

    @Override
    public String toString() {
        return diseaseName; // Hiển thị tên trong JComboBox
    }
    
    // ... getters and setters
    private int diseaseId;
    private String diseaseName;
    private String description;
    private String treatment;
    private int departmentId;

    public Disease() {}

    public Disease(int diseaseId, String diseaseName, String description, String treatment, int departmentId) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.description = description;
        this.treatment = treatment;
        this.departmentId = departmentId;
    }

    public int getDiseaseId() { return diseaseId; }
    public void setDiseaseId(int diseaseId) { this.diseaseId = diseaseId; }

    public String getDiseaseName() { return diseaseName; }
    public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
}