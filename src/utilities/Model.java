package utilities;

import java.awt.Dimension;
import object.Turtle;
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
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final String TITLE = "SLOGO";

    private Turtle myTurtle;

    private DisplayArea myDisArea;

    private TurtleArea myTurArea;

    private Controller myController;

    public Model (Controller controller) {
        myController = controller;
        myTurtle = new Turtle();
        myDisArea = new DisplayArea(DisplayArea.DEFAULT_AREA_SIZE, myTurtle);
        myTurArea = new TurtleArea(TurtleArea.DEFAULT_AREA_SIZE, myTurtle);

    }

    public void update () {
        System.out.println("update!");
        myDisArea.update();
        myTurArea.update();
    }

    public Turtle getMyTurtle () {
        return myTurtle;
    }

}
