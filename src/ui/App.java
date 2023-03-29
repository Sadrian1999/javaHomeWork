package ui;
import java.awt.*;
import javax.swing.*;

import ui.mainpanels.NewCount;
import ui.mainpanels.PrevCount;
import ui.mainpanels.Profile;
import ui.mainpanels.Settings;
import ui.ownelements.MenuItem;
import ui.ownelements.Menubar;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class App extends JFrame implements MouseListener{

    private CardLayout cardLayout = new CardLayout();

    private JPanel containter = new JPanel(new BorderLayout());
    private JPanel contentPanels = new JPanel(cardLayout);

    private NewCount newCountPanel = new NewCount();
    private PrevCount prevCountPanel = new PrevCount();
    private Settings settingsPanel = new Settings();
    private Profile profilePanel = new Profile();

    private Menubar menu = new Menubar();

    private MenuItem newCount = new MenuItem(Values.newCountPath, "Új számítás");
    private MenuItem prevCount = new MenuItem(Values.prevCountPath, "Előző számítások ");
    private MenuItem settings = new MenuItem(Values.settingsPath, "Beállítások");
    private MenuItem profile = new MenuItem(Values.profilePath, "Profil");

    
    public App(){
        menuSettings();
        panelSettings();
        appSettings();
        containter.setBounds(0, 0, Values.MAIN_WIDTH, Values.MAIN_HEIGHT);
        this.add(containter);
        cardLayout.show(contentPanels, "prevCount");
        newCount.addMouseListener(this);
        prevCount.addMouseListener(this);
        profile.addMouseListener(this);
        settings.addMouseListener(this);
    }
    private void menuSettings(){
        menu.add(newCount);
        menu.add(prevCount);
        menu.add(settings);
        menu.add(profile);
        containter.add(menu, BorderLayout.WEST);

    }
    private void panelSettings(){
        contentPanels.setSize(Values.CONTENT_SIZE);
        contentPanels.add(newCountPanel, "newCount");
        contentPanels.add(prevCountPanel, "prevCount");
        contentPanels.add(settingsPanel, "settings");
        contentPanels.add(profilePanel, "profile");
        containter.add(contentPanels, BorderLayout.CENTER);
    }
    private void appSettings() {
        this.setSize(Values.BASE_SIZE);
        this.setTitle("Salary Counter");
        this.getContentPane().setBackground(Values.BASE_BG_COLOR);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
    public static void main(String[] args){
        new App();
    }
    
}
