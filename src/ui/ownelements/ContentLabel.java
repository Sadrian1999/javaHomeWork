package ui.ownelements;

import java.awt.*;
import javax.swing.JLabel;


public class ContentLabel extends JLabel {
    private static final String FONT_NAME = "Vonique 64";

    public ContentLabel(int size, String text) {
        super(text);
        this.setAlignmentY(Component.LEFT_ALIGNMENT);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, size));
    }
}
