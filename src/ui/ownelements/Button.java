package ui.ownelements;

import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton{
    private static final String FONT_NAME = "Vonique 64";
    public Button(int width, int height, String text, int fontSize) {
        this.setText(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, fontSize));
        this.setSize(width, height);
    }
    public Button(int width, int height, String text) {
        this.setText(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
        this.setSize(width, height);
    }
    public Button(String text) {
        this.setText(text);
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
        this.setSize(14, 15);
    }

}
