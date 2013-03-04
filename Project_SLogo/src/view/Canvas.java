package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import object.Trail;  
import utilities.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Canvas {

    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final String TITLE = "SLOGO";

    private Controller myController;
    private Turtle myTurtle;
    private Trail myTrail; 

    public Canvas (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyTurtle();
        myTrail=myTurtle.getTrail(); 
        createGUI();
    }

    public void createGUI () {

        JFrame myFrame = new JFrame(TITLE);
        JPanel myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle, myTrail);
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

}
