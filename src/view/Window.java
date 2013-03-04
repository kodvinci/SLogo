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
    public static final String TITLE = "SLOGO";
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
        System.out.println("Window!");
        super.paintComponent(pen);
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);

        if (myTurtle != null) {
            myTurtle.get(0).paint((Graphics2D) pen);
            System.out.println("Window Turtle!");
        }
    }

}
