package ui.ownelements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MenuItem extends JLabel implements MouseListener{
    private static final int MENU_ITEM_WIDTH = 50;
    private static final int MENU_ITEM_HEIGHT = 50;

    private static final Dimension MENU_ITEM_SIZE = new Dimension(MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT);
    private static final Color MENU_BAR_COLOR = new Color(0x635985);
    private static final Color MENU_HOVER_COLOR = new Color(0xE384FF);
    private static final String FONT_NAME = "Vonique 64";
    /**
     * My menu label for havin an icon and a text next to it in the menu bar.
     * @param path the path of the label icon
     * @param text the text of the label
     */
    public MenuItem(String path, String text) {
        this.setIcon(new ImageIcon(path));
        this.setText(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        this.setOpaque(true);
        this.setBackground(MENU_BAR_COLOR);
        this.setSize(MENU_ITEM_SIZE);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { 
        if(e.getSource()==this) { this.setBackground(MENU_HOVER_COLOR); }
    }
    public void mouseExited(MouseEvent e) { 
        if(e.getSource()==this) { this.setBackground(MENU_BAR_COLOR); }     
    }
}
