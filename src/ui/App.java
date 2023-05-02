package ui;
import java.awt.*;
import javax.swing.*;

import engine.Engine;
import ui.mainpanels.NewCount;
import ui.mainpanels.PrevCount;
import ui.mainpanels.Profile;
import ui.mainpanels.Settings;
import ui.ownelements.MenuItem;
import ui.ownelements.Menubar;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class App extends JFrame implements MouseListener{

    private Engine engine;

    private static final int MAIN_WIDTH = 1000;
    private static final int MAIN_HEIGHT = 600;
    private static final int MENU_BAR_WIDTH = 101;
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

    private NewCount newCountPanel = new NewCount();
    private PrevCount prevCountPanel = new PrevCount();
    private Settings settingsPanel = new Settings();
    private Profile profilePanel = new Profile();

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
        cardLayout.show(contentPanels, "prevCount");
        while (true) {
            adding();  

        }
    }
    
//********************************************************************************************
//*                                     NEW COUNT                                            *
//********************************************************************************************

    private void adding(){
        while (!newCountPanel.isEndOfAdding()) {
            if (newCountPanel.isReadyToAdd()) {
                System.out.println(newCountPanel.isEndOfAdding() + "\n" + newCountPanel.isReadyToAdd());
                engine.addDay(newCountPanel.getDay(), newCountPanel.getDate()); 
            }
        }
        System.out.println(engine.getDays());
    }

//********************************************************************************************
//*                                     PANEL SETTINGS                                       *
//********************************************************************************************


    private void menuSettings(){
        menu.add(newCount);
        menu.add(prevCount);
        menu.add(settings);
        menu.add(profile);
        containter.add(menu, BorderLayout.WEST);

    }
    private void panelSettings(){
        contentPanels.setSize(CONTENT_SIZE);
        contentPanels.add(newCountPanel, "newCount");
        contentPanels.add(prevCountPanel, "prevCount");
        contentPanels.add(settingsPanel, "settings");
        contentPanels.add(profilePanel, "profile");
        containter.add(contentPanels, BorderLayout.CENTER);
        newCount.addMouseListener(this);
        prevCount.addMouseListener(this);
        profile.addMouseListener(this);
        settings.addMouseListener(this);
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
//*                                     EVENT SECTION                                        *
//********************************************************************************************

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
