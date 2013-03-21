package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import object.Trail;
import object.Turtle;
import util.Location;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class TurtleArea extends Window {

    private static final String RESOURCE = "/images/background/";
    private static final long serialVersionUID = 1L;
    private static final int FIRST_TURTLE = 0;
    private static final int GRID_VALUE = 100;
    private static final Color TRAIL_COLOR = Color.BLACK;
    private static final Color GRID_COLOR = Color.BLACK;
    private static final int GRID_LABEL_OFFSET = 20;
    private boolean toggledOn = true;
    private Trail myTrail;
    private Canvas myView;
    private List<Turtle> myTurtles;
    private java.awt.Image myBackgroundImage;
    private static final int TOGGLE_KEY = KeyEvent.VK_SPACE;
    private int myLastKeyPressed;
    public static final int NO_KEY_PRESSED = -1;

    /**
     * 
     * @param size
     *        size of display area
     * @param turtles
     *        pen image
     * @param canvas
     *        view
     *        Constructs TurtleArea
     */
    public TurtleArea (Dimension size, List<Turtle> turtles, Canvas canvas) {
        super(size, "English");
        setFocusable(true);

        myBackgroundImage =
                new ImageIcon(getClass().getResource(RESOURCE + "dukeblue.gif")).getImage();

        myView = canvas;
        myTurtles = turtles;
        myTrail = myTurtles.get(FIRST_TURTLE).getTrail();

        setVisible(true);

        setInputListeners();
    }

    /**
     * Paints turtle and trail
     * 
     * @param pen
     *        Graphics pen for drawing
     */
    @Override
    public void paint (Graphics pen) {
        super.paintComponent(pen);

        if (myBackgroundImage != null) {
            pen.drawImage(myBackgroundImage, 0, 0, null);
        }

        paintTurtle((Graphics2D) pen);
        paintTrails((Graphics2D) pen);
        toggleGrid();
        paintGrid((Graphics2D) pen);

        // rotation
        rotatePen((Graphics2D) pen);

        Toolkit.getDefaultToolkit().sync();
        pen.dispose();
    }

    private void rotatePen (Graphics2D pen) {
        for (Turtle t : myTurtles) {
            t.paint(pen, t.getCenter(), t.getSize(), t.getAngle());
        }
    }

    /**
     * Updates turtles' trails and their location
     */
    public void update () {
        for (Turtle t : myTurtles) {
            t.addTrail();
        }

        myTurtles.get(FIRST_TURTLE).addTrail();
        revalidate();
        myView.update();

    }

    /**
     * paints all the turtles and updates their trails
     */
    private void paintTurtle (Graphics2D pen) {

        for (Turtle t : myTurtles) {
            t.paint(pen);
            t.addTrail();
        }

    }

    /**
     * 
     * Paints all trails that the turtle has traveled
     */
    private void paintTrails (Graphics2D pen) {
        pen.setColor(TRAIL_COLOR);
        List<Location> trails = myTrail.getTrails();
        if (!(trails.isEmpty())) {
            Location prevLocation = myTrail.getTrails().get(FIRST_TURTLE);
            Location newLocation;
            for (int i = 1; i < trails.size(); i++) {
                newLocation = trails.get(i);
                pen.drawLine((int) prevLocation.getX(), (int) prevLocation.getY(),
                             (int) newLocation.getX(), (int) newLocation.getY());
                prevLocation = newLocation;
            }
        }
    }

    private void paintGrid (Graphics2D pen) {
        pen.setColor(GRID_COLOR);
        if (toggledOn) {
            for (int i = 0; i < getWidth(); i += GRID_VALUE) {
                pen.drawLine(i, 0, i, getHeight());
                pen.drawString(Integer.toString(i), i, GRID_LABEL_OFFSET);
            }
            for (int i = 0; i < getWidth(); i += GRID_VALUE) {
                pen.drawLine(0, i, getWidth(), i);
                pen.drawString(Integer.toString(i), 0, i);
            }
        }

    }

    private void toggleGrid () {
        System.out.println("test");
        if (myLastKeyPressed == TOGGLE_KEY) {
            toggledOn = !toggledOn;
        }
    }

    private void setInputListeners () {
        // initialize input state
        myLastKeyPressed = NO_KEY_PRESSED;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                myLastKeyPressed = e.getKeyCode();
            }

            @Override
            public void keyReleased (KeyEvent e) {
                myLastKeyPressed = NO_KEY_PRESSED;
            }
        });

    }

    /**
     * 
     * @param filename 
     *      name of new background
     */
    public void changeBackgroundImage (String filename) {
        myBackgroundImage =
                new ImageIcon(getClass().getResource(RESOURCE + filename)).getImage();
        repaint();
    }

}
