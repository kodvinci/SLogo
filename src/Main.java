import java.awt.Dimension;
import exceptions.NoSuchVariableException;
import utilities.Controller;


/**
 * 
 * @author Leonard
 * 
 */
public class Main {

    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final String TITLE = "SLOGO";

    /**
     * @param args nothing
     */
    public static void main (String[] args) {

        Controller myController = new Controller();
        // new Canvas(myController);
        // new Window(myController);

        myController.processUserInput(0, "Make arcueid 10 make makubex ");
        System.out.println(myController.getModel(0).getMyTurtle().getX());
        System.out.println(myController.getModel(0).getMyTurtle().getY());
        System.out.println(myController.getModel(0).getMyTurtle().getMyAngle());
        try {
            System.out.println(myController.getModel(0).getVariableValue("arcueid"));
            System.out.println(myController.getModel(0).getVariableValue("makubex"));
        }
        catch (NoSuchVariableException e) {
            System.out.println("no such variable");
        }

    }

}
