package clinic_management_dao;

public class Room {
    private int roomId; 
    private String roomNumber; 
    private int departmentId; 
    private String departmentName;
    private int capacity; 
    private String status; 
    public Room(int roomId, String roomNumber, int departmentId, String departmentName, int capacity, String status){
        this.roomId = roomId; 
        this.roomNumber = roomNumber; 
        this.departmentId = departmentId;
        this.departmentName = departmentName; 
        this.capacity = capacity; 
        this.status = status; 
    }
    public Room(){
        
    }
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
