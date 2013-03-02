import java.awt.Dimension;
import utilities.Controller;
import view.Window;


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
     * @param args
     */
    public static void main (String[] args) {

        Controller myController = new Controller();
        // new Canvas(myController);
        //new Window(myController);

         System.out.println(myController.getMyModels().size());
         myController.processUserInput(0,"FD 10 10 100 FD 10 LT 90asdas");
         System.out.println(myController.getModel(0).getMyTurtle().getX());
         System.out.println(myController.getModel(0).getMyTurtle().getY());
         System.out.println(myController.getModel(0).getMyTurtle().getMyAngle());

    }

}
