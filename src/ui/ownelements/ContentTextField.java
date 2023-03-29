package ui.ownelements;

import javax.swing.JTextField;

import ui.Values;

import java.awt.Component;

public class ContentTextField extends JTextField {

    public ContentTextField(int columns, int textSize) {
        super(columns);
        this.setAlignmentY(Component.LEFT_ALIGNMENT);
        this.setMaximumSize(this.getPreferredSize());
        this.setFont(Values.baseFont(textSize));
    }
    
}
