package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Window extends JPanel {

    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    public static final String USER_DIR = "user.dir";
    public ResourceBundle myResources;

    public JFrame myFrame;
    public JPanel myPanel;
    //
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final Dimension SIZE1 = new Dimension(1000, 700);
    private static final int FIRST_TURTLE=0; 
    private static final Color BACKGROUND_COLOR=Color.WHITE; 
    public static final String TITLE = "SLOGO";
    private static final int X_INDEX=0; 
    private static final int Y_INDEX=0; 
    private Controller myController;
    private List<Turtle> myTurtle;
    //

    private static final int ENTER_KEY = KeyEvent.VK_ENTER;
    private static final long serialVersionUID = 1L;
    private KeyListener myKeyListener;
    private JFileChooser myChooser;
    private Canvas myView;

    public Window (Controller controller) {
        // makeKeyListener();
        myController = controller;
        myTurtle = myController.getMyTurtles();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));

        // addKeyListener(myKeyListener);
    }

    public Window (Dimension size, String language) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }

    public Window (Dimension size, String language, Canvas canvas) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myView = canvas;
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(BACKGROUND_COLOR);
        pen.fillRect(X_INDEX, Y_INDEX, getSize().width, getSize().height);

        if (myTurtle != null) {
            myTurtle.get(FIRST_TURTLE).paint((Graphics2D) pen);
        }
    }

}
