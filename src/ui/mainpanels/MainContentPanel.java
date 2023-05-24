package ui.mainpanels;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class MainContentPanel extends JPanel{

    private static final int MAIN_WIDTH = 1000;
    private static final int MAIN_HEIGHT = 600;
    private static final int MENU_BAR_WIDTH = 101;
    private static final int CONTENT_WIDTH = MAIN_WIDTH - MENU_BAR_WIDTH;
    private static Color BASE_BG_COLOR = new Color(0x865DFF);

    public MainContentPanel() {
        this.setBounds(MENU_BAR_WIDTH, 0, CONTENT_WIDTH, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }
}
