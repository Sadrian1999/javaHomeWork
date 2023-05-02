//********************************************************************************************
//*                                     NEW COUNT PANEL                                      *
//********************************************************************************************

/**
 * This class is the main interface of the program, here the user can add a clocking
 * @button Add adds it to the engine's days hashmap
 * @button Count sets the endOfAdding to true, so no more clockings will be added
 * 
 * The user can also add how many days they had paid off or sick
 */
package ui.mainpanels;
import javax.swing.*;

import logics.Clocking;
import logics.Day;
import ui.ownelements.ContentLabel;
import ui.ownelements.ContentPanel;
import ui.ownelements.ContentTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class NewCount extends JPanel implements ContentPanel{
    private Day day;
    private boolean endOfAdding = false;
    private boolean readyToAdd = false;
    private String[] date; 

    private static final int MAIN_WIDTH = 1000;
    private static final int MAIN_HEIGHT = 600;
    private static final int MENU_BAR_WIDTH = 101;
    private static final int CONTENT_WIDTH = MAIN_WIDTH - MENU_BAR_WIDTH;
    private static Color BASE_BG_COLOR = new Color(0x865DFF);

    public boolean isEndOfAdding() {
        return endOfAdding;
    }
    public boolean isReadyToAdd() {
        return readyToAdd;
    }

    public NewCount() {
       setup();
       content();
    }

    public void setup(){
        this.setBounds(0, 0, CONTENT_WIDTH, MAIN_HEIGHT);
        this.setBackground(BASE_BG_COLOR);
        this.setLayout(new BorderLayout());
    }
    @Override
    public void content() {
        int labelSize = 18;
        int textSize = 14;
        int fieldWidth = 10; 
        
        ContentTextField datetTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField clockInTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField clockOutTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField paidOfftTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField sicktTextField = new ContentTextField(fieldWidth, textSize);

        ContentLabel clockInLabel = new ContentLabel(labelSize, "Be:");
        ContentLabel clockOutLabel = new ContentLabel(labelSize, "Ki:");
        ContentLabel datetLabel = new ContentLabel(labelSize, "Dátum:");
        ContentLabel paidOffLabel = new ContentLabel(labelSize, "Szabadság:");
        ContentLabel sickLabel = new ContentLabel(labelSize, "Táppénz:");

        JButton count = new JButton("Számítás");
        JButton add = new JButton("Hozzáad");

        JPanel columnOne = new JPanel();
        columnOne.setBackground(BASE_BG_COLOR);
        columnOne.setLayout(new BoxLayout(columnOne, BoxLayout.Y_AXIS));

        JPanel columnTwo = new JPanel();
        columnTwo.setBackground(BASE_BG_COLOR);
        columnTwo.setLayout(new BoxLayout(columnTwo, BoxLayout.Y_AXIS));

        JPanel dateBox = new JPanel(new BorderLayout());
        JPanel clkIn = new JPanel(new BorderLayout());
        JPanel clkOut = new JPanel(new BorderLayout());
        JPanel paidOffBox = new JPanel(new BorderLayout());
        JPanel sickBox = new JPanel(new BorderLayout());
        JPanel addButtonBox = new JPanel(new BorderLayout());
        JPanel countButtonBox = new JPanel(new BorderLayout());

        addBox(datetLabel, datetTextField, dateBox, columnOne);
        addBox(clockInLabel, clockInTextField, clkIn, columnOne);
        addBox(clockOutLabel, clockOutTextField, clkOut, columnOne);
        addBox(paidOffLabel, paidOfftTextField, paidOffBox, columnTwo);
        addBox(sickLabel, sicktTextField, sickBox, columnTwo);

        addButtonBox.add(add, BorderLayout.CENTER);
        addButtonBox.setBackground(BASE_BG_COLOR);
        countButtonBox.add(count, BorderLayout.CENTER);
        countButtonBox.setBackground(BASE_BG_COLOR);

        columnOne.add(Box.createRigidArea(new Dimension(100,42)));
        columnTwo.add(Box.createRigidArea(new Dimension(100, 91)));
        columnOne.add(addButtonBox);
        columnTwo.add(countButtonBox);
        columnOne.add(Box.createRigidArea(new Dimension(100,500)));
        columnTwo.add(Box.createRigidArea(new Dimension(100, 500)));

        JPanel helpingPanel = new JPanel(new BorderLayout());

        helpingPanel.setBackground(BASE_BG_COLOR);
        helpingPanel.add(columnTwo, BorderLayout.WEST);
        this.add(columnOne, BorderLayout.WEST);
        this.add(helpingPanel, BorderLayout.CENTER);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                day = (new Day(new Clocking(clockInTextField.getText(), clockOutTextField.getText()), false));
                if (!datetTextField.getText().isEmpty()){
                    String[] splits = datetTextField.getText().split(".");
                    date[0] = splits[0];
                    date[1] = splits[1];
                    date[2] = splits[2];
                    }
                readyToAdd = true;
            }
        });

        count.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                endOfAdding = true;
            }
        });
    }
    private void addBox(JLabel label, JTextField textField, JPanel panel, JPanel parent){
        panel.setBackground(BASE_BG_COLOR);
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.SOUTH);
        parent.add(panel);
    }
    public Day getDay(){
        return day;
    }
    public LocalDate getDate(){
        return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
    }
}