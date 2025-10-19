package clinic_management_dao;

import java.time.LocalDate;
import java.util.Date;

public class User {
 
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private java.time.Instant createAt;

    public User() {
        
    }
    public User(int id, String username, String password, String fullName, String email, java.time.Instant createAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.createAt = createAt;
      
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

