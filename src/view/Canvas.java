package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import utilities.Controller;


/**
 * 
 * @author Leonard
 * 
 */
public class Canvas {

    /**
     * 
     */
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    /**
     * 
     */
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    /**
     * 
     */
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    /**
     * 
     */
    public static final Dimension SIZE = new Dimension(1100, 700);
    /**
     * 
     */
    public static final String TITLE = "SLOGO";

    private Controller myController;
    private Turtle myTurtle;
    private JPanel myPanel;
    private JFrame myFrame;

    /**
     * 
     * @param controller
     *        Slogo controller
     */
    public Canvas (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyTurtle();
        createGUI();
    }

    /**
     * 
     */
    public void createGUI () {

        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        // Window myWindow = new Window(myController);
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle, this);
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

    /**
     * 
     */
    public void update () {
        System.out.println("Canvas update");
        Random rand = new Random();
        int hack = rand.nextInt(10);
        Dimension SIZE = new Dimension(1050 + hack, 700);
        myPanel.setSize(SIZE);
        myFrame.revalidate();
    }
}
