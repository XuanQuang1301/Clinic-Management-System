package clinic_management_dao;

public class Patient {
    private int id;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;
    private String bloodGroup;
    private String email;
    private String insuranceNumber;

    // Constructor
    public Patient(int id, String fullName, String gender, String phoneNumber,
                   String dateOfBirth, String address, String bloodGroup,
                   String email, String insuranceNumber) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.insuranceNumber = insuranceNumber;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getInsuranceNumber() { return insuranceNumber; }
    public void setInsuranceNumber(String insuranceNumber) { this.insuranceNumber = insuranceNumber; }
<<<<<<< HEAD
}
=======
}
>>>>>>> 68af0b23c52c9671770ef9de5519e12c470d72e6
