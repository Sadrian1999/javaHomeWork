package ui.mainpanels;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Column extends JPanel{
    private static final Color BASE_BG_COLOR = new Color(0x865DFF);
    private static final int MAIN_HEIGHT = 600;

    public Column(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 100, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
    }

    public Column(JComponent[] components, int rigidAreaHeight) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 100, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        for (JComponent jComponent : components) {
            this.add(jComponent);
        }
        this.add(Box.createRigidArea(new Dimension(0, rigidAreaHeight)));
    }

    public Column(JComponent[] components, int rigidAreaHeight, int rigidAreaHeightTwo, int indexOfSecondArea) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 100, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        for (int i = 0; i <= indexOfSecondArea; i++) {
            this.add(components[i]);
        }
        this.add(Box.createRigidArea(new Dimension(0, rigidAreaHeight)));
        for (int i = indexOfSecondArea + 1; i < components.length; i++) {
            this.add(components[i]);
        }
        this.add(Box.createRigidArea(new Dimension(0, rigidAreaHeightTwo)));
    }

    public Column(ArrayList<JComponent> components, int rigidAreaHeight) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 100, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        for (JComponent jComponent : components) {
            this.add(jComponent);
        }
        this.add(Box.createRigidArea(new Dimension(0, rigidAreaHeight)));
    }
    public void addBox(int height){
        this.add(Box.createRigidArea(new Dimension(0, height)));
    }
}
