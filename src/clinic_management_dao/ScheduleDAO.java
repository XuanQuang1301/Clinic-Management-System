package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    // Trả về list chuỗi để debug / in ra console
    public List<String> getAllSchedulesAsText() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT s.schedule_id, d.full_name, s.schedule_date, r.room_number " +
                     "FROM schedules s " +
                     "JOIN doctors d ON s.doctor_id = d.doctor_id " +
                     "JOIN rooms r ON s.room_id = r.room_id " +
                     "ORDER BY s.schedule_date DESC";

        try (Connection con = Connect.ConnectDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String row = "ID: " + rs.getInt("schedule_id") +
                             ", Doctor: " + rs.getString("full_name") +
                             ", Date: " + rs.getDate("schedule_date") +
                             ", Room: " + rs.getString("room_number");
                list.add(row);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllSchedulesAsText: " + e.getMessage());
        }
        return list;
    }

    // Trả về list object[] để đổ vào JTable
    public List<Object[]> getAllSchedules() {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT s.schedule_id, d.full_name, s.schedule_date, r.room_number " +
                     "FROM schedules s " +
                     "JOIN doctors d ON s.doctor_id = d.doctor_id " +
                     "JOIN rooms r ON s.room_id = r.room_id " +
                     "ORDER BY s.schedule_date DESC";

        try (Connection con = Connect.ConnectDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getInt("schedule_id");
                row[1] = rs.getString("full_name");
                row[2] = rs.getDate("schedule_date");
                row[3] = rs.getString("room_number");
                list.add(row);
            }
        } catch (SQLException e) {
            System.err.println("Error getAllSchedules: " + e.getMessage());
        }
        return list;
    }
}
