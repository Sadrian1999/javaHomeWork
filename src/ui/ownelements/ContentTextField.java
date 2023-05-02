package ui.ownelements;
import java.awt.Font;
import javax.swing.JTextField;

public class ContentTextField extends JTextField {
    private static final String FONT_NAME = "Vonique 64";
    private static final Font BASE_FONT (int size) { return new Font(FONT_NAME, Font.PLAIN, size);}

    public ContentTextField(int columns, int textSize) {
        super(columns);
        this.setMaximumSize(this.getPreferredSize());
        this.setFont(BASE_FONT(textSize));
    }
    
}