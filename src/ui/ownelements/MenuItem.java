package ui.ownelements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.Values;

import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.event.MouseEvent;

public class MenuItem extends JLabel implements MouseListener{

    public MenuItem(String path, String text) {
        this.setIcon(new ImageIcon(path));
        this.setText(text);
        this.setFont(new Font(Values.FONT_NAME, Font.PLAIN, 20));
        this.setOpaque(true);
        this.setBackground(Values.MENU_BAR_COLOR);
        this.setSize(Values.MENU_ITEM_SIZE);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { 
        if(e.getSource()==this) { this.setBackground(Values.MENU_HOVER_COLOR); }
    }
    public void mouseExited(MouseEvent e) { 
        if(e.getSource()==this) { this.setBackground(Values.MENU_BAR_COLOR); }     
    }
}
