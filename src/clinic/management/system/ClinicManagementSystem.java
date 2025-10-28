
package clinic.management.system;
import clinic_management_ui.LoginForm;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.UIManager;
public class ClinicManagementSystem {
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Cài đặt Look and Feel của FlatLaf
            UIManager.setLookAndFeel(new FlatLightLaf());

            // 2. Định nghĩa bảng màu mới
            Color primaryPink = new Color(255, 228, 225); // Màu hồng nền chính (Pastel Pink)
            Color buttonBg = new Color(245, 245, 245);    // Màu xám rất nhạt cho nút
            Color buttonHoverBg = new Color(230, 230, 230); // Màu nút khi di chuột qua để tạo hiệu ứng

            // 3. Áp dụng màu sắc
            // Đặt màu nền chính
            UIManager.put("Panel.background", primaryPink);
            UIManager.put("Frame.background", primaryPink);
             UIManager.put("OptionPane.background", primaryPink);
            UIManager.put("Table.background", primaryPink);

            // Đặt màu cho nút bấm
            UIManager.put("Button.background", buttonBg);
            UIManager.put("Button.foreground", Color.BLACK); // Chữ đen cho dễ đọc
            UIManager.put("Button.hoverBackground", buttonHoverBg); // Thêm hiệu ứng hover

            // Giữ lại các cài đặt accent và selection (có thể chỉnh lại cho hợp tông)
            UIManager.put("Component.accentColor", new Color(255, 105, 180)); // Màu hồng đậm hơn cho điểm nhấn
            UIManager.put("Component.selectionBackground", new Color(255, 182, 193));
            UIManager.put("Table.selectionBackground", new Color(255, 182, 193));

            // Giữ lại bo góc cho hiện đại
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 10);
            UIManager.put("TextComponent.arc", 10);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

}
