package clinic_management_dao;

public class Doctor {
    private int doctorId;
    private String fullName;
    private String gender;
    private String dateOfBirth; // có thể dùng java.sql.Date nếu muốn quản lý dạng DATE
    private String email;
    private String phoneNumber;
    private String specialization;
    private int departmentId;

    public Doctor() {
    }

    public Doctor(int doctorId, String fullName, String gender, String dateOfBirth,
                  String email, String phoneNumber, String specialization, int departmentId) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    // Getters & Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
