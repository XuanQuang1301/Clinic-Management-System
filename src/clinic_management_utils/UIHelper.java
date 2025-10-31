package clinic_management_utils;

import java.awt.*;

public class UIHelper {
    public static void setupGlobalCentering() {
        // Khi bất kỳ cửa sổ Swing nào hiển thị, tự căn giữa nó
        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (event.getSource() instanceof Window window) {
                if (!window.isLocationByPlatform()) {
                    window.setLocationRelativeTo(null);
                }
            }
        }, AWTEvent.WINDOW_EVENT_MASK);
    }

    public static void centerWindow(Window window) {
        window.setLocationRelativeTo(null);
    }
}
