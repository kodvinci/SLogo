package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Map;
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

    private static final long serialVersionUID = 1L;
    private static final int FIRST_TURTLE = 0;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 0;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    private JFileChooser myChooser;
    private Controller myController;
    private Map<Integer, Turtle> myTurtle;
    private Canvas myView;
    private ResourceBundle myResources;

    /**
     * 
     * @param controller
     *        default controller
     *        Constructs Window and sets controller
     */
    public Window (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyTurtles(0);
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
    }

    /**
     * @param size
     *        display size
     * @param language
     *        international considerations
     *        Constructs window
     */
    public Window (Dimension size, String language) {
        initWindowProperties(size);
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
     *        Constructs window and sets canvas
     */
    public Window (Dimension size, String language, Canvas canvas) {
        initWindowProperties(size);
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myView = canvas;
    }

    /**
     * 
     * Sets window properties
     */
    private void initWindowProperties (Dimension size) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
    }

    /**
     * Paints window
     * 
     * @param pen
     *        Graphics pen used for drawing
     */

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(BACKGROUND_COLOR);
        pen.fillRect(X_INDEX, Y_INDEX, getSize().width, getSize().height);

        if (myTurtle != null) {
            myTurtle.get(FIRST_TURTLE).paint((Graphics2D) pen);
        }
    }

    /**
     * 
     * @return the resource Bundle
     */
    public ResourceBundle getResourceBundle () {
        return myResources;
    }

    @Override
    public int getWidth () {
        return getSize().width;
    }

    @Override
    public int getHeight () {
        return getSize().height;
    }

}
