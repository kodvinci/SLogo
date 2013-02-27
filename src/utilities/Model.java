package utilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import object.Turtle;
import view.CommandArea;
import view.DisplayArea;
import view.TurtleArea;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Model {

    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final String TITLE = "SLOGO";
    
    private Turtle myTurtle;

    private DisplayArea myDisArea;

    private CommandArea myComArea;

    private TurtleArea myTurArea;
   
    private Controller myController;
    
    public Model (Controller controller) {
        myController = controller;
        myDisArea = new DisplayArea(DisplayArea.DEFAULT_AREA_SIZE);
        myComArea = new CommandArea(CommandArea.DEFAULT_AREA_SIZE, myController);
        myTurArea = new TurtleArea(TurtleArea.DEFAULT_AREA_SIZE, myTurtle);
        myTurtle = new Turtle();
    }

    public void update () {

        myDisArea.update();
        myComArea.update();
        myTurArea.update();
    }

    public Turtle getMyTurtle () {
        return myTurtle;
    }

}
