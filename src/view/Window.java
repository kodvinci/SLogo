package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import object.Turtle;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Window extends JPanel {

    /**
     * 
     */
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    /**
     * 
     */
    public static final String USER_DIR = "user.dir";
    

    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final String TITLE = "SLOGO";
    private static final int FIRST_TURTLE = 0;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 0;
    private static final long serialVersionUID = 1L;

    private ResourceBundle myResources;
    private JFileChooser myChooser;
    private Controller myController;
    private List<Turtle> myTurtle;
    private Canvas myView;

    /**
     * 
     * @param controller
     *        default controller
     */
    public Window (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyTurtles();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
    }

    /**
     * 
     * @param size
     *        display size
     * @param language
     *        international considerations
     */
    public Window (Dimension size, String language) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }

    /**
     * 
     * @param size
     *        display size
     * @param language
     *        international conventions
     * @param canvas
     *        the view
     */
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
