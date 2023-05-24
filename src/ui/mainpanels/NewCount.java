package ui.mainpanels;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ui.ownelements.Button;
import ui.ownelements.Label;
import ui.ownelements.TextField;

public class NewCount extends MainContentPanel{
    private int FieldTextSize = 14;
    private int FieldSize = 15;

    private Label dateLabel = new Label("Dátum");
    private Label clockInLabel = new Label("Be");
    private Label clockOutLabel = new Label("Ki");
    private Label doubleMoneyLabel = new Label("Dupla bér?");
    private Label paidOffLabel = new Label("Szabadság");
    private Label sickLabel = new Label("Táppénz");
    private Label dateMsg = new Label("", 13);

    private TextField dateText = new TextField(FieldTextSize, FieldSize);
    private TextField clockInText = new TextField(FieldTextSize, FieldSize);
    private TextField clockOutText = new TextField(FieldTextSize, FieldSize);
    private TextField paidOffTextField = new TextField(FieldTextSize, FieldSize);
    private TextField sickTextField = new TextField(FieldTextSize, FieldSize);
    private JCheckBox doubleMoney = new JCheckBox();

    private Button add = new Button(FieldTextSize, FieldSize, "Hozzáadás");
    private Button count = new Button(FieldTextSize, FieldSize, "Számítás");

    public NewCount(Button add, Button count) {
        Column firstColumn = new Column(new JComponent[]{dateLabel, dateText, paidOffLabel, paidOffTextField}, 600);
        Column secondColumn = new Column(new JComponent[] {clockInLabel, clockInText, sickLabel, sickTextField}, 600);
        Column thirdColumn = new Column(new JComponent[] {clockOutLabel, clockOutText, doubleMoneyLabel, doubleMoney}, 600);
        Column fourthColumn = new Column(new JComponent[] {add, count, dateMsg}, 600);

        this.add(firstColumn);
        this.add(secondColumn);
        this.add(thirdColumn);
        this.add(fourthColumn);
    }
    
}
