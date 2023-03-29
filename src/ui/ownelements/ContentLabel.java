package ui.ownelements;

import java.awt.*;
import javax.swing.JLabel;

import ui.Values;

public class ContentLabel extends JLabel {

    public ContentLabel(int size, String text) {
        super(text);
        this.setAlignmentY(Component.LEFT_ALIGNMENT);
        this.setFont(new Font(Values.FONT_NAME, Font.PLAIN, size));
    }
}
