package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection conn; 
    public RoomDAO(Connection conn){
        this.conn = conn; 
    }
    public RoomDAO(){
        
    }
    // Lấy tất cả phòng
    public List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT r.room_id, r.room_number, r.department_id, d.department_name, " +
                     "r.capacity, r.status " +
                     "FROM rooms r " +
                     "JOIN departments d ON r.department_id = d.department_id " +
                     "ORDER BY r.room_id";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Room r = new Room(
                    rs.getInt("room_id"),
                    rs.getString("room_number"),
                    rs.getInt("department_id"),
                    rs.getString("department_name"), // lấy tên từ bảng departments
                    rs.getInt("capacity"),
                    rs.getString("status")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllRooms: " + e.getMessage());
        }
        return list;
    }
    
    // Thêm phòng mới
    public boolean insertRoom(Room r) {
        String sql = "INSERT INTO rooms (room_number, department_id, capacity, status) VALUES (?, ?, ?, ?)";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, r.getRoomNumber());
            pst.setInt(2, r.getDepartmentId());
            pst.setInt(3, r.getCapacity());
            pst.setString(4, r.getStatus());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error insertRoom: " + e.getMessage());
        }
        return false;
    }
    
    // Cập nhật phòng
    public boolean updateRoom(Room r) {
        String sql = "UPDATE rooms SET room_number=?, department_id=?, capacity=?, status=? WHERE room_id=?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, r.getRoomNumber());
            pst.setInt(2, r.getDepartmentId());
            pst.setInt(3, r.getCapacity());
            pst.setString(4, r.getStatus());
            pst.setInt(5, r.getRoomId());
            
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updateRoom: " + e.getMessage());
        }
        return false;
    }
    
    // Xóa phòng theo ID
    public boolean deleteRoom(int roomId) {
        String sql = "DELETE FROM rooms WHERE room_id=?";
        try (Connection con = Connect.ConnectDB();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setInt(1, roomId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleteRoom: " + e.getMessage());
        }
        return false;
    }
}
