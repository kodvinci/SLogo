package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Canvas {

    /**
     * default turtle size
     */
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    private static final int WIDTH = 1050;
    private static final int HEIGHT = 700;
    private static final int RANGE = 10;
    /**
     * default display area size
     */
    private static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    /**
     * default command area size
     */
    private static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    /**
     * default size
     */
    private static final Dimension SIZE = new Dimension(1100, 700);
    /**
     * title
     */
    private static final String TITLE = "SLOGO";
    private int myWidth = WIDTH;
    private int myHeight = HEIGHT;
    private int myRange = RANGE;
    private Controller myController;
    private JPanel myPanel;
    private JFrame myFrame;
    private List<Turtle> myTurtle;
    private TurtleArea myTurtleArea;

    /**
     * 
     * @param controller constructor
     *        Sets the controller and turtle variable and calls to creat GUI
     */
    public Canvas (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyModels().get(0).getMyTurtles();

        createGUI();
    }

    /**
     * Creates the Toolbar and Display, Turtle and Command Areas
     */
    public void createGUI () {

        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle, this);
        myFrame.getContentPane().add(myTurtleArea, BorderLayout.CENTER);

        // for turtle status display
        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE, myTurtle);
        myFrame.getContentPane().add(myDisplay, BorderLayout.EAST);

        // for user input display
        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE, myController);
        myFrame.getContentPane().add(myInput, BorderLayout.SOUTH);

        // add tool bar area
        ToolBarArea myMenu = new ToolBarArea(myController);
        myFrame.setJMenuBar(myMenu);

        myFrame.pack();
        myFrame.setVisible(true);
    }

    /**
     * Resize the view
     */
    public void update () {
        Random rand = new Random();
        myPanel.setSize(new Dimension(myWidth + rand.nextInt(myRange), myHeight));
        myFrame.validate();
    }

    /**
     * 
     * @return
     *         turtle view area
     */
    public TurtleArea getTurtleArea () {
        return myTurtleArea;
    }
}
