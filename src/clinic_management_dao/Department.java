package clinic_management_dao;

import java.math.BigDecimal;

public class Department {
    private int departmentId;
    private String departmentName;
    private String description;
    private BigDecimal consultationFee;
    public Department()
    {
    }
    public Department(int departmentId, String departmentName, String description,BigDecimal consultationFee)
    {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.consultationFee = consultationFee;
    }
    public void setDepartmentId(int id)
    {
        this.departmentId = id;
    }
    public void setDepartmentName(String name)
    {
        this.departmentName = name;
    }
    public void setConsultationFee(BigDecimal consultationFee)
    {
        this.consultationFee = consultationFee;
    }
    public int getDepartmentId()
    {
        return this.departmentId;
    }
    public String getDepartmentName()
    {
        return this.departmentName;
    }
    public BigDecimal getConsultationFee()
    {
        return this.consultationFee;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    @Override
    public String toString() {
        return this.departmentName;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 68af0b23c52c9671770ef9de5519e12c470d72e6
