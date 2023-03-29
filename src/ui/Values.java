package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public abstract class Values {
    public static int MAIN_WIDTH = 1000;
    public static int MAIN_HEIGHT = 600;
    public static int MENU_BAR_WIDTH = 101;
    public static int MENU_ITEM_WIDTH = 50;
    public static int MENU_ITEM_HEIGHT = 50;
    public static int CONTENT_WIDTH = MAIN_WIDTH - MENU_BAR_WIDTH;

    public static Dimension BASE_SIZE = new Dimension(MAIN_WIDTH, MAIN_HEIGHT);
    public static Dimension MENU_SIZE = new Dimension(MENU_BAR_WIDTH, MAIN_HEIGHT);
    public static Dimension CONTENT_SIZE = new Dimension(CONTENT_WIDTH, MAIN_HEIGHT);
    public static Dimension MENU_ITEM_SIZE = new Dimension(MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT);

    public static Color BASE_BG_COLOR = new Color(0x865DFF);
    public static Color MENU_BAR_COLOR = new Color(0x635985);
    public static Color MENU_HOVER_COLOR = new Color(0xE384FF);

    public static String TITLE = "Salary Counter";
    public static String newCountPath = "assets/new_count.png";
    public static String prevCountPath = "assets/previous_count.png";
    public static String settingsPath = "assets/settings.png";
    public static String profilePath = "assets/profile.png";
    public static String FONT_NAME = "Vonique 64";

    public static Border RIGHT_BORDER = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
    public static Font baseFont(int size) { return new Font(FONT_NAME, Font.PLAIN, size);}
}   
