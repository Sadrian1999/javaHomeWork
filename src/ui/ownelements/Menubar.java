package ui.ownelements;

import java.awt.GridLayout;
import javax.swing.JPanel;

import ui.Values;

public class Menubar extends JPanel{
    public Menubar() {
        panelSettings();
    }

    private void panelSettings(){
        this.setSize(Values.MENU_SIZE);
        this.setBackground(Values.MENU_BAR_COLOR);
        this.setLayout(new GridLayout(7,1));
        this.setBorder(Values.RIGHT_BORDER);
    }
}
