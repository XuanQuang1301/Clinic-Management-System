package clinic_management_dao;

import clinic_management_ui.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class ScheduleDAO {
    private Connection conn;

    public ScheduleDAO(Connection conn){
        this.conn = conn;
    }

    public List<Object[]> getSchedulesWithAppointmentDate() {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT " +
                     "s.schedule_id, " +
                     "d.full_name, " +
                     "COALESCE(s.schedule_date, a.appointment_date) AS schedule_date, " +
                     "r.room_number " +
                     "FROM doctors d " +
                     "CROSS JOIN rooms r " +
                     "LEFT JOIN schedules s ON s.doctor_id = d.doctor_id AND s.room_id = r.room_id " +
                     "LEFT JOIN appointments a ON a.doctor_id = d.doctor_id AND a.room_id = r.room_id " +
                     "ORDER BY schedule_date DESC";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try (Connection con = this.conn != null ? this.conn : Connect.ConnectDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()){
                Object[] row = new Object[4];
                row[0] = rs.getObject("schedule_id");
                row[1] = rs.getString("full_name");

                Date date = rs.getDate("schedule_date");
                row[2] = (date != null) ? sdf.format(date) : ""; // format sang String
                row[3] = rs.getString("room_number");
                list.add(row);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Object[]> getAllSchedules() {
        List<Object[]> list = new ArrayList<>();
        String sql = "SELECT s.schedule_id, d.full_name, s.schedule_date, r.room_number " +
                     "FROM doctors d " +
                     "CROSS JOIN rooms r " +
                     "LEFT JOIN schedules s ON s.doctor_id = d.doctor_id AND s.room_id = r.room_id " +
                     "ORDER BY s.schedule_date DESC";

        try (Connection con = this.conn != null ? this.conn : Connect.ConnectDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()){
                Object[] row = new Object[4];
                row[0] = rs.getObject("schedule_id");
                row[1] = rs.getString("full_name");
                row[2] = rs.getObject("schedule_date");
                row[3] = rs.getString("room_number");
                list.add(row);
            }

        } catch(SQLException e){
            System.err.println("Error getAllSchedules: " + e.getMessage());
        }

        return list;
    }
}
