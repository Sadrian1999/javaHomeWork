package ui.mainpanels;
import javax.swing.*;

import ui.Values;
import ui.ownelements.ContentLabel;
import ui.ownelements.ContentPanel;
import ui.ownelements.ContentTextField;

import java.awt.*;

public class NewCount extends JPanel implements ContentPanel{
    
    public NewCount() {
       setup();
       content();
    }

    public void setup(){
        this.setBounds(0, 0, Values.CONTENT_WIDTH, Values.MAIN_HEIGHT);
        this.setBackground(Values.BASE_BG_COLOR);
        this.setLayout(new BorderLayout());
    }
    @Override
    public void content() {
        int labelSize = 18;
        int textSize = 14;
        int fieldWidth = 20;
        
        ContentTextField date = new ContentTextField(fieldWidth, textSize);
        ContentTextField clockInTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField clockOutTextField = new ContentTextField(fieldWidth, textSize);
        ContentTextField paidOff = new ContentTextField(fieldWidth, textSize);
        ContentTextField sick = new ContentTextField(fieldWidth, textSize);

        ContentLabel clockInLabel = new ContentLabel(labelSize, "Be:");
        ContentLabel clockOutLabel = new ContentLabel(labelSize, "Ki:");
        ContentLabel datetLabel = new ContentLabel(labelSize, "Dátum:");
        ContentLabel paidOffLabel = new ContentLabel(labelSize, "Szabadság:");
        ContentLabel sickLabel = new ContentLabel(labelSize, "Táppénz:");

        JPanel columnOne = new JPanel();
        columnOne.setBackground(new Color(0x00ff00));
        columnOne.setLayout(new BoxLayout(columnOne, BoxLayout.Y_AXIS));

        JPanel columnTwo = new JPanel();
        columnTwo.setBackground(new Color(0xff00ff));
        columnTwo.setLayout(new BoxLayout(columnTwo, BoxLayout.Y_AXIS));

        columnOne.add(datetLabel);
        columnOne.add(Box.createRigidArea(new Dimension(0, 10)));
        columnOne.add(date);
        columnOne.add(Box.createRigidArea(new Dimension(0, 10)));
        columnOne.add(clockInLabel);
        columnOne.add(Box.createRigidArea(new Dimension(0, 10)));
        columnOne.add(clockInTextField);
        columnOne.add(Box.createRigidArea(new Dimension(0, 10)));
        columnOne.add(clockOutLabel);
        columnOne.add(Box.createRigidArea(new Dimension(0, 10)));
        columnOne.add(clockOutTextField);

        columnTwo.add(paidOffLabel);
        columnTwo.add(Box.createRigidArea(new Dimension(0, 10)));
        columnTwo.add(paidOff);
        columnTwo.add(Box.createRigidArea(new Dimension(0, 10)));
        columnTwo.add(sickLabel);
        columnTwo.add(Box.createRigidArea(new Dimension(0, 10)));
        columnTwo.add(sick);

        this.add(columnOne, BorderLayout.WEST);
        this.add(columnTwo, BorderLayout.CENTER);
    }
    
}
