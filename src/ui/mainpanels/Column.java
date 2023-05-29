package ui.mainpanels;
import java.awt.*;
import javax.swing.*;

public class Column extends JPanel{
    private static final Color BASE_BG_COLOR = new Color(0x865DFF);
    private static final int MAIN_HEIGHT = 600;
    /**
     * The column class creates a JPanel functioning like a column so its easier to work with in the main file.
     */
    public Column(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 50, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
    }
    /**
     *  Here we want to put a box after the groups
     * @param components the components needs to be added to the column
     * @param rigidAreaHeight is the height needed for the box under the elements for styling purposes
     */
    public Column(JComponent[] components, int rigidAreaHeight) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBounds(0, 0, 50, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        for (JComponent jComponent : components) {
            this.add(jComponent);
        }
        this.add(Box.createRigidArea(new Dimension(0, rigidAreaHeight)));
    }
    /**
     * Here we want to put a box between 2 component groups
     * @param components the components needs to be added to the column
     * @param rigidAreaHeight is the height needed for the box under the elements for styling purposes
     * @param rigidAreaHeightTwo is the second height for the purpuse above
     * @param indexOfSecondArea where the second section starts
     */
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
    public void addBox(int height){
        this.add(Box.createRigidArea(new Dimension(0, height)));
    }
}
