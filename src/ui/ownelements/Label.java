package ui.ownelements;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{
    private static final String FONT_NAME = "Vonique 64";

    public Label(String text, int size) {
        super(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, size));
    }
    public Label(String text) {
        super(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
    }
    
}
