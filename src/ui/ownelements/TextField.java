package ui.ownelements;

import java.awt.Font;
import javax.swing.JTextField;

public class TextField extends JTextField{
    private static final String FONT_NAME = "Vonique 64";
    public TextField() {
        super(15);
        this.setMaximumSize(this.getPreferredSize());
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 14));
    }
    public TextField(int size) {
        super(15);
        this.setMaximumSize(this.getPreferredSize());
        this.setFont(new Font(FONT_NAME, Font.PLAIN, size));
    }
    public TextField(int size, int column) {
        super(column);
        this.setMaximumSize(this.getPreferredSize());
        this.setFont(new Font(FONT_NAME, Font.PLAIN, size));
    }
    
}
