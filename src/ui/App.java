package ui;
import java.awt.*;
import javax.swing.*;

import engine.Engine;
import logics.Clocking;
import logics.Day;
import logics.Money;
import logics.User;
import ui.Errors.ClockingConvertException;
import ui.mainpanels.Column;
import ui.mainpanels.MainContentPanel;
import ui.mainpanels.NewCount;
import ui.ownelements.Label;
import ui.ownelements.TextField;
import ui.ownelements.MenuItem;
import ui.ownelements.Menubar;
import ui.ownelements.Button;

import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class App extends JFrame implements MouseListener{

    private Engine engine = new Engine();

    private static final int MAIN_WIDTH = 1000;
    private static final int MAIN_HEIGHT = 600;
    private static final int MENU_BAR_WIDTH = 100;
    private static final int CONTENT_WIDTH = MAIN_WIDTH - MENU_BAR_WIDTH;

    private static final Dimension BASE_SIZE = new Dimension(MAIN_WIDTH, MAIN_HEIGHT);
    private static final Dimension CONTENT_SIZE = new Dimension(CONTENT_WIDTH, MAIN_HEIGHT);

    private static final Color BASE_BG_COLOR = new Color(0x865DFF);

    private static final String TITLE = "Salary Counter";
    private static final String NEW_COUNT_PATH = "assets/new_count.png";
    private static final String PREV_COUNT_PATH = "assets/previous_count.png";
    private static final String SETTINGS_PATH = "assets/settings.png";
    private static final String PROFILE_PATH = "assets/profile.png";


//********************************************************************************************
//*                                     MAIN FRAME SECTION                                   *
//********************************************************************************************
/**
 * The variable container holds the right side of the content, that will be swapped when a
 * different menu is being clicked on.
 */
    
    private CardLayout cardLayout = new CardLayout();

    private JPanel containter = new JPanel(new BorderLayout());
    private JPanel contentPanels = new JPanel(cardLayout);

    private MainContentPanel prevCountPanel = new MainContentPanel();
    private MainContentPanel settingsPanel = new MainContentPanel();
    private MainContentPanel profilePanel = new MainContentPanel();
    private MainContentPanel reportPanel = new MainContentPanel();

//********************************************************************************************
//*                                     MENU SECTION                                         *
//********************************************************************************************
/**
 * The menu consists of the sidebar, holding the different options to chose from.
 */
     
    private Menubar menu = new Menubar();

    private MenuItem newCount = new MenuItem(NEW_COUNT_PATH, "Új számítás");
    private MenuItem prevCount = new MenuItem(PREV_COUNT_PATH, "Előző számítások ");
    private MenuItem settings = new MenuItem(SETTINGS_PATH, "Beállítások");
    private MenuItem profile = new MenuItem(PROFILE_PATH, "Profil");

    
    
//********************************************************************************************
//*                                       RUNNING                                            *
//********************************************************************************************
    
    public App(){
        menuSettings();
        panelSettings();
        appSettings();
        cardLayout.show(contentPanels, "profile");
    }
    
//********************************************************************************************
//*                                     NEW COUNT                                            *
//********************************************************************************************
    private int FieldSize = 15;
    private Label dateMsg = new Label("", 13);

    private TextField dateText = new TextField();
    private TextField clockInText = new TextField();
    private TextField clockOutText = new TextField();
    private TextField paidOffTextField = new TextField();
    private TextField sickTextField = new TextField();
    private JCheckBox doubleMoney = new JCheckBox();

    private Button add = new Button("Hozzáadás");
    private Button count = new Button("Számítás");

    private MainContentPanel newCountPanel = new MainContentPanel();

//********************************************************************************************
//*                                     REPORT                                               *
//********************************************************************************************

    private Label base = new Label("0");
    private Label thirtyPercent = new Label("0");
    private Label fourtyPercent  = new Label("0");
    private Label hundredPercent = new Label("0");
    private Label sickHours = new Label("0");
    private Label paidOfF = new Label("0");
    private Label baseMoney = new Label("0 Ft");
    private Label thirtyMoney = new Label("0 Ft");
    private Label fourtyMoney = new Label("0 Ft");
    private Label hundredMoney = new Label("0 Ft");
    private Label paidOffMoney = new Label("0 Ft");
    private Label sickMoney = new Label("0 Ft");

    private Label totalHours = new Label("0");
    private Label brutt = new Label("0 Ft");
    private Label nett = new Label("0 Ft");

    private Button close = new Button("Bezárás");
    private Button saveReport = new Button("Számítás mentése");
    private Button confirm = new Button("Mentés");

    private TextField fileName = new TextField();
    
//********************************************************************************************
//*                                     PREV COUNT                                           *
//********************************************************************************************

    private TextField selectPrev = new TextField();
    private Button select = new Button("Kiválaszt");
    private ArrayList<String> savedFiles = new ArrayList<>();

//********************************************************************************************
//*                                     SETTINGS                                             *
//********************************************************************************************

    private int settingsTextFieldSize = 10;

    private Label nameLabel = new Label("Név");
    private Label positionlLabel = new Label("Pozíció");
    private Label appliacationTypeLabel = new Label("Foglalkoztatás");
    private Label ageLabel = new Label("Életkor");
    private Label wageLabel = new Label("Órabér");
    private Label jobTimeLabel = new Label("Foglalkoztatásidő");
    private Label isVemlLabel = new Label("VÉM?");
    private Label isTaxFreLabel = new Label("Adómentes?");

    private TextField nameTextField = new TextField();
    private TextField posTextField = new TextField();
    private TextField applicationTextField = new TextField();
    private TextField ageTextField = new TextField();
    private TextField wagTextField = new TextField();
    private TextField jobTimetTextField = new TextField();
    private TextField isVemtTextField = new TextField();
    private TextField isTaxFreTextField = new TextField();


    private Button save = new Button("Mentés");

//********************************************************************************************
//*                                     PROFILE                                              *
//********************************************************************************************

    private JLabel profilePicture = new JLabel(new ImageIcon(new ImageIcon(engine.getMoney().getUser().getProfilePicturePath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
    private JFileChooser fileChooser = new JFileChooser();
    private Button changeProfilePicture = new Button("Tallózás");
    private Button saveProfilePicture = new Button("Mentés");
    private String profilePicturePath;

//********************************************************************************************
//*                                     PANEL SETTINGS                                       *
//********************************************************************************************

    private String previousPanel;

    private void menuSettings(){
        menu.add(newCount);
        menu.add(prevCount);
        menu.add(settings);
        menu.add(profile);
        containter.add(menu, BorderLayout.WEST);

    }
    private void panelSettings(){
        contentPanels.setSize(CONTENT_SIZE);

        newCountPanelSettings();
        settingsPanelSettings();
        reportPanelSettings();
        prevCountPanelSettings();
        profilePanelSettings();
        buttonActions();

        contentPanels.add(newCountPanel, "newCount");
        contentPanels.add(prevCountPanel, "prevCount");
        contentPanels.add(settingsPanel, "settings");
        contentPanels.add(profilePanel, "profile");
        contentPanels.add(reportPanel, "report");
        containter.add(contentPanels, BorderLayout.CENTER);
        newCount.addMouseListener(this);
        prevCount.addMouseListener(this);
        profile.addMouseListener(this);
        settings.addMouseListener(this);
    }
    
    private void newCountPanelSettings(){
        Label dateLabel = new Label("Dátum");
        Label clockInLabel = new Label("Be");
        Label clockOutLabel = new Label("Ki");
        Label doubleMoneyLabel = new Label("Dupla bér?");
        Label paidOffLabel = new Label("Szabadság");
        Label sickLabel = new Label("Táppénz");
        
        Column firstColumn = new Column(new JComponent[]{dateLabel, dateText, paidOffLabel, paidOffTextField}, 600);
        Column secondColumn = new Column(new JComponent[] {clockInLabel, clockInText, sickLabel, sickTextField}, 600);
        Column thirdColumn = new Column(new JComponent[] {clockOutLabel, clockOutText, doubleMoneyLabel, doubleMoney}, 600);
        Column fourthColumn = new Column(new JComponent[] {add, count, dateMsg}, 600);

        newCountPanel.add(firstColumn);
        newCountPanel.add(secondColumn);
        newCountPanel.add(thirdColumn);
        newCountPanel.add(fourthColumn);
    }
    private void reportPanelSettings(){
        JComponent[] firstElements = new JComponent[] {
            new Label("Pótlék"), new Label("Alap"), new Label("30%"), new Label("40%"), 
            new Label("100%"), new Label("Táppénz"), new Label("Szabadság"), 
            new Label("Összesen"), new Label("Nettó"), close, saveReport
        }; 
        JComponent[] secondElements = new JComponent[] {
            new Label("Óraszám"), base, thirtyPercent, fourtyPercent, hundredPercent, sickHours, paidOfF, totalHours, nett, fileName, confirm
        };
        JComponent[] thirdElements = new JComponent[] {
            new Label("Forint"), baseMoney, thirtyMoney, fourtyMoney, hundredMoney, sickMoney, paidOffMoney, brutt
        };

        fileName.setVisible(false);
        confirm.setVisible(false);
        Column firstColumn = new Column(firstElements, 300, 300, 8);
        Column secondColumn = new Column(secondElements, 300, 300, 8);
        Column thirdColumn = new Column(thirdElements, 600);

        reportPanel.add(firstColumn);
        reportPanel.add(secondColumn);
        reportPanel.add(thirdColumn);
    }
    private void prevCountPanelSettings(){
        Column firstColumn = new Column();
        File f = new File(System.getProperty("user.dir"));
        File[] files = f.listFiles();
        firstColumn.add(selectPrev);
        firstColumn.add(select);
        for (File file : files) {
            if (file.getName().endsWith(".ser") && !file.getName().equals("user.ser")) {
                firstColumn.add(new Label(file.getName()));
            }
        }
        firstColumn.addBox(500);

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                previousPanel = "prevCount";
                for (File fileName : files) {
                    if (fileName.getName().equals(selectPrev.getText())) {
                        Money redMoney = Money.read(selectPrev.getText());
                        base.setText(String.format("%.2f",redMoney.getBase()));
                        thirtyPercent.setText(String.format("%.2f",redMoney.getThirty()));
                        fourtyPercent.setText(String.format("%.2f",redMoney.getFourty()));
                        hundredPercent.setText(String.format("%.2f",redMoney.getHundred()));
                        sickHours.setText(String.format("%.2f",(redMoney.getSick()) * redMoney.getUser().getJobTime()));
                        paidOfF.setText(String.format("%.2f",(redMoney.getPaidOff() * redMoney.getUser().getJobTime())));
                        totalHours.setText(String.format("%.2f",redMoney.getBase()));
                        nett.setText(String.format("%.0f Ft",redMoney.getNett()));
                        
                        baseMoney.setText(String.format("%.0f Ft",redMoney.getBaseMoney()));
                        thirtyMoney.setText(String.format("%.0f Ft",redMoney.getThirtyMoney()));
                        fourtyMoney.setText(String.format("%.0f Ft",redMoney.getFourtyMoney()));
                        hundredMoney.setText(String.format("%.0f Ft",redMoney.getHundredMoney()));
                        sickMoney.setText(String.format("%.0f Ft",redMoney.getSickMoney()));
                        paidOffMoney.setText(String.format("%.0f Ft",redMoney.getPaidOffMoney()));
                        brutt.setText(String.format("%.0f Ft",redMoney.getGross()));
                        cardLayout.show(contentPanels, "report");
                        
                        saveReport.setVisible(false);
                        cardLayout.show(contentPanels, "report");
                    }
                }
            }
        });
        prevCountPanel.add(firstColumn);
    }
    private void settingsPanelSettings() {
        
        JPanel firstColumn = new JPanel();
        firstColumn.setLayout(new BoxLayout(firstColumn, BoxLayout.Y_AXIS));
        firstColumn.setBounds(0, 0, 100, MAIN_HEIGHT);
        firstColumn.setBackground(BASE_BG_COLOR);
        firstColumn.add(nameLabel);
        firstColumn.add(ageLabel);
        firstColumn.add(wageLabel);
        firstColumn.add(positionlLabel);
        firstColumn.add(appliacationTypeLabel);
        firstColumn.add(jobTimeLabel);
        firstColumn.add(isTaxFreLabel);
        firstColumn.add(isVemlLabel);
        firstColumn.add(Box.createRigidArea(new Dimension(0, 400)));

        JPanel secondColumn = new JPanel();
        secondColumn.setLayout(new BoxLayout(secondColumn, BoxLayout.Y_AXIS));
        secondColumn.setBounds(100, 0, 100, MAIN_HEIGHT);
        secondColumn.setBackground(BASE_BG_COLOR);
        secondColumn.add(nameTextField);
        secondColumn.add(ageTextField);
        secondColumn.add(wagTextField);
        secondColumn.add(posTextField);
        secondColumn.add(applicationTextField);
        secondColumn.add(jobTimetTextField);
        secondColumn.add(isTaxFreTextField);
        secondColumn.add(isVemtTextField);
        secondColumn.add(save);

        secondColumn.add(Box.createRigidArea(new Dimension(0, 400)));

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int age = Integer.parseInt(ageTextField.getText());
                int wage = Integer.parseInt(wagTextField.getText());
                int jobTime = Integer.parseInt(jobTimetTextField.getText());
                boolean isVem = Boolean.parseBoolean(isVemtTextField.getText());
                boolean isTaxFree = Boolean.parseBoolean(isTaxFreTextField.getText());
                String name = nameTextField.getText();
                String position = posTextField.getText();
                String applicationType = applicationTextField.getText();
                User user = new User(age, wage, jobTime, isVem, isTaxFree, name, position, applicationType);
                engine.getMoney().setUser(user);
                user.write();
            }
        });
        settingsPanel.add(firstColumn);
        settingsPanel.add(secondColumn);
    }
    private void profilePanelSettings(){
        String userProfilePath = engine.getMoney().getUser().getProfilePicturePath();
        String userName = engine.getMoney().getUser().getName();
        String userAgeString = String.valueOf(engine.getMoney().getUser().getAge());
        String userPosition = engine.getMoney().getUser().getPosition();

        if (userProfilePath == null) {
            profilePicture.setIcon(new ImageIcon("assets/default_profile.png"));
        }
        Column firstColumn = new Column(new JComponent[]{profilePicture, changeProfilePicture}, 300, 100, 0);
        Column secondColumn = new Column(new JComponent[]
        { new Label(userName, 25), new Label(userAgeString, 20), new Label(userPosition), saveProfilePicture}, 445, 100, 2);
        saveProfilePicture.setVisible(false);

        profilePanel.add(firstColumn);
        profilePanel.add(secondColumn);
    }
   
    private void appSettings() {
        this.setSize(BASE_SIZE);
        this.setTitle(TITLE);
        this.getContentPane().setBackground(BASE_BG_COLOR);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        containter.setBounds(0, 0, MAIN_WIDTH, MAIN_HEIGHT);
        this.add(containter);
    }

//********************************************************************************************
//*                                     ERROR HANDLING                                       *
//********************************************************************************************

    public ArrayList newCountErrors(){
        Clocking clocking;
        LocalDate date;
        ArrayList<Object> datas = new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();
        String clockInString = clockInText.getText();
        String clockOutString = clockOutText.getText();
        String dateString = dateText.getText();
        int inLength = clockInString.length();
        int outLength = clockOutString.length();

        errors.add("ERROR");
        datas.add("DATA");
        try {
            date = LocalDate.parse(dateString);
            datas.add(date);
        } 
        catch (Exception e) {
            errors.add("Hibás dátum!");
        }

        try {
            int inHour = Integer.parseInt(clockInString.substring(0, 1));
            int inMin = Integer.parseInt(clockInString.substring(3, 4));
            int outHour = Integer.parseInt(clockOutString.substring(0, 1));
            int outMin = Integer.parseInt(clockOutString.substring(3, 4));
            int sickDays = Integer.parseInt(sickTextField.getText());
            int paidOffDays = Integer.parseInt(paidOffTextField.getText());

            if (inLength != 5 || inHour < 0 || inHour > 23 || inMin < 0 || inMin > 59 ||!clockInString.contains(":")){
                throw new ClockingConvertException();
            }
            if (outLength != 5 || outHour < 0 || outHour > 23 || outMin < 0 || outMin > 59 ||!clockOutString.contains(":")){
                throw new ClockingConvertException();
            }
            clocking = new Clocking(clockInString, clockOutString);
            datas.add(Double.valueOf(sickDays));
            datas.add(Double.valueOf(paidOffDays));
            datas.add(clockInString);
            datas.add(clockOutString);
            datas.add(clocking);
        } 
        catch (ClockingConvertException e) {
            errors.add(e.getMessage());
        } 
        catch (NumberFormatException e) {
            errors.add("Sikertelen számkonvertálás!");
        }
        catch (StringIndexOutOfBoundsException e) {
            errors.add("Sikertelen számkonvertálás!");
        }

        if (errors.size() == 1) {
            return datas;
        }
        else {
            return errors;
        }
    }

//********************************************************************************************
//*                                     EVENT SECTION                                        *
//********************************************************************************************
    public void buttonActions(){
        File file = new File(System.getProperty("user.dir"));
        File[] files = file.listFiles();
        ArrayList<String> daysForLabel = new ArrayList<>();
        for (File fileName : files ) {
            if (!fileName.isDirectory() && fileName.getName().endsWith(".ser") && !fileName.getName().contains("user.ser")) {
                savedFiles.add(fileName.getName());
            }
        }
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList data = newCountErrors();
                dateMsg.setText("<html>");
                if (data.get(0) == "DATA") {
                    daysForLabel.add("Hozzáadva: " + dateText.getText());
                    engine.addDay(new Day((Clocking)data.get(6), doubleMoney.isSelected()), (LocalDate)data.get(1));
                    for (String dateString : daysForLabel) {
                        dateMsg.setText(dateMsg.getText() + dateString + "<br>");
                    }

                } else {
                    data.remove(0);
                    daysForLabel.addAll(data);
                    for (String dateString : daysForLabel) {
                        dateMsg.setText(dateMsg.getText() + dateString + "<br>");
                    }
                }
                dateMsg.setText(dateMsg.getText() + "</html>");
                engine.getMoney().setPaidOff((double)data.get(3));
                engine.getMoney().setSick((double)data.get(2));
                engine.countHoursForDay();
                engine.getMoney().calculate();
                dateText.setText(null);
                clockInText.setText(null);
                clockOutText.setText(null);
            }
        });

        count.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                previousPanel = "newCount";
                base.setText(String.format("%.2f",engine.getBase()));
                thirtyPercent.setText(String.format("%.2f",engine.getThirty()));
                fourtyPercent.setText(String.format("%.2f",engine.getFourty()));
                hundredPercent.setText(String.format("%.2f",engine.getHundred()));
                sickHours.setText(String.format("%.2f",(engine.getSick()) * engine.getMoney().getUser().getJobTime()));
                paidOfF.setText(String.format("%.2f",(engine.getPaidOff() * engine.getMoney().getUser().getJobTime())));
                totalHours.setText(String.format("%.2f",engine.getBase()));
                nett.setText(String.format("%.0f Ft",engine.getMoney().getNett()));

                baseMoney.setText(String.format("%.0f Ft",engine.getBaseMoney()));
                thirtyMoney.setText(String.format("%.0f Ft",engine.getThirtyMoney()));
                fourtyMoney.setText(String.format("%.0f Ft",engine.getFourtyMoney()));
                hundredMoney.setText(String.format("%.0f Ft",engine.getHundredMoney()));
                sickMoney.setText(String.format("%.0f Ft",engine.getSickMoney()));
                paidOffMoney.setText(String.format("%.0f Ft",engine.getPaidOffMoney()));
                brutt.setText(String.format("%.0f Ft",engine.getMoney().getGross()));
                saveReport.setVisible(true);
                cardLayout.show(contentPanels, "report");
            }
        });

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cardLayout.show(contentPanels, previousPanel);
            }
        });

        saveReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (confirm.isVisible()) {
                confirm.setVisible(false);
                fileName.setVisible(false);
                }   
                else {
                    confirm.setVisible(true);
                    fileName.setVisible(true);
                }
            }
        });

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (fileName.getText() == "" || !fileName.getText().endsWith(".ser")) {
                    fileName.setText("Hibás fájlnév!");
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    fileName.setText("");
                }
                else {
                    engine.getMoney().write(fileName.getText());
                }
            }
        });

        changeProfilePicture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                saveProfilePicture.setVisible(true);
                int r = fileChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    profilePicturePath = fileChooser.getSelectedFile().getAbsolutePath();
                    ImageIcon newPic = new ImageIcon(new ImageIcon(profilePicturePath).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                    profilePicture.setIcon(newPic);
                }
            }
        });
        saveProfilePicture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                engine.getMoney().getUser().setProfilePicturePath(profilePicturePath);
                engine.getMoney().getUser().write();
                saveProfilePicture.setVisible(false);
            }
        });
    }

    public void mouseClicked(MouseEvent e) 
    {
        if (e.getSource() == newCount) {
            cardLayout.show(contentPanels, "newCount");
        }
        else if (e.getSource() == prevCount) {
            cardLayout.show(contentPanels, "prevCount");
        }
        else if (e.getSource() == settings) {
            cardLayout.show(contentPanels, "settings");
        }
        else if (e.getSource() == profile) {
            cardLayout.show(contentPanels, "profile");
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    public void engineWorking(){

    }
    public static void main(String[] args){
        new App();
    }
    
}
