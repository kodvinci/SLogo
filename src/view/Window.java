package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import utilities.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Window extends JPanel {

    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    public static final String USER_DIR = "user.dir";
    public ResourceBundle myResources;

    //
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final String TITLE = "SLOGO";
    private Controller myController;
    private Turtle myTurtle;
    //

    private static final int ENTER_KEY = KeyEvent.VK_ENTER;
    private static final long serialVersionUID = 1L;
    private KeyListener myKeyListener;

    public Window (Controller controller) {
        makeKeyListener();
        myController = controller;
        myTurtle = myController.getMyTurtle();
        createGUI();
        addKeyListener(myKeyListener);
    }

    public Window (Dimension size, String language) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }

    @Override
    public void paintComponent (Graphics pen) {
        System.out.println("Window!");
        super.paintComponent(pen);
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);

        if (myTurtle != null) {
            myTurtle.paint((Graphics2D) pen);
            System.out.println("Window Turtle!");
        }
    }

    public void createGUI () {

        JFrame myFrame = new JFrame(TITLE);
        JPanel myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle);
        myFrame.getContentPane().add(myTurtleArea, BorderLayout.CENTER);

        // for turtle status display
        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE, myTurtle);
        myFrame.getContentPane().add(myDisplay, BorderLayout.EAST);

        // for user input display
        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE, myController);
        myFrame.getContentPane().add(myInput, BorderLayout.SOUTH);

        myFrame.pack();
        myFrame.setVisible(true);
    }

    private void makeKeyListener () {
        System.out.println("made listener");
        myKeyListener = new KeyListener() {
            @Override
            public void keyPressed (KeyEvent e) {
                System.out.println("keyPressed");
                if (e.equals(ENTER_KEY)) {
                    System.out.println("KEY KEY");
                    repaint();
                }
            }

            @Override
            public void keyReleased (KeyEvent e) {
                System.out.println("keyReleased");
            }

            @Override
            public void keyTyped (KeyEvent e) {
                System.out.println("keyTyped");
            }
        };
    }

}
