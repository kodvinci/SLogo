package utilities;

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

    private Turtle myTurtle;

    private DisplayArea myDisArea;

    private CommandArea myComArea;

    private TurtleArea myTurArea;

    public Model () {
        myDisArea = new DisplayArea(DisplayArea.DEFAULT_AREA_SIZE);
        myComArea = new CommandArea(CommandArea.DEFAULT_AREA_SIZE);
        myTurArea = new TurtleArea(TurtleArea.DEFAULT_AREA_SIZE);
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