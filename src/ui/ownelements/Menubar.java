package ui.ownelements;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Menubar extends JPanel{
    private static final int MENU_BAR_WIDTH = 101;
    private static final int MAIN_HEIGHT = 600;
    private static final Dimension MENU_SIZE = new Dimension(MENU_BAR_WIDTH, MAIN_HEIGHT);
    private static final Color MENU_BAR_COLOR = new Color(0x635985);
    private static final Border RIGHT_BORDER = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
    
    public Menubar() {
        panelSettings();
    }

    private void panelSettings(){
        this.setSize(MENU_SIZE);
        this.setBackground(MENU_BAR_COLOR);
        this.setLayout(new GridLayout(7,1));
        this.setBorder(RIGHT_BORDER);
    }
}
