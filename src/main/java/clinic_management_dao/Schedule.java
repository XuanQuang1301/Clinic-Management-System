package clinic_management_dao;

import java.sql.Date;

public class Schedule {
    private int scheduleId;
    private int doctorId;
    private Date scheduleDate;
    private int roomId;

    public Schedule() {
    }

    public Schedule(int scheduleId, int doctorId, Date scheduleDate, int roomId) {
        this.scheduleId = scheduleId;
        this.doctorId = doctorId;
        this.scheduleDate = scheduleDate;
        this.roomId = roomId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
