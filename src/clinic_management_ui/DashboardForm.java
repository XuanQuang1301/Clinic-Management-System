package clinic_management_ui;

import clinic_management_dao.DashboardDAO;
import clinic_management_dao.Dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardForm extends JFrame {
    private JLabel lblTotalAppointments;
    private JLabel lblCompletedAppointments;
    private JLabel lblCancelledAppointments;
    private JLabel lblRevenue;

    public DashboardForm(JFrame parent) {
        setTitle("Dashboard Báo Cáo");
        setSize(520, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        lblTotalAppointments = new JLabel("Tổng số lượt khám: ...", SwingConstants.CENTER);
        lblTotalAppointments.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTotalAppointments);

        lblCompletedAppointments = new JLabel("Số lượt khám hoàn thành: ...", SwingConstants.CENTER);
        lblCompletedAppointments.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblCompletedAppointments);

        lblCancelledAppointments = new JLabel("Số lượt khám bị hủy: ...", SwingConstants.CENTER);
        lblCancelledAppointments.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblCancelledAppointments);

        lblRevenue = new JLabel("Tổng doanh thu: ... VNĐ", SwingConstants.CENTER);
        lblRevenue.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblRevenue);

        add(panel);

        // Load số liệu thực tế từ DAO/model
        loadStatistics();
    }

    private void loadStatistics() {
        DashboardDAO dao = new DashboardDAO();
        Dashboard dashboard = dao.getDashboardStatistics();

        lblTotalAppointments.setText("Tổng số lượt khám: " + dashboard.getTotalAppointments());
        lblCompletedAppointments.setText("Số lượt khám hoàn thành: " + dashboard.getCompletedAppointments());
        lblCancelledAppointments.setText("Số lượt khám bị hủy: " + dashboard.getCancelledAppointments());
        lblRevenue.setText("Tổng doanh thu: " + String.format("%.0f VNĐ", dashboard.getTotalRevenue()));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new DashboardForm(null).setVisible(true));
    }
}