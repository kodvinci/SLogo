import java.awt.Dimension;
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
     * @param args
     */
    public static void main (String[] args) {
         System.out.println("start");
       
         Controller myControl = new Controller();
         
         System.out.println(myControl.getMyModels().size());
         myControl.processUserInput(0,"fd 10 fD 10 Lt 90 Fd 10");
         System.out.println(myControl.getModel(0).getMyTurtle().getX());
         System.out.println(myControl.getModel(0).getMyTurtle().getY());
         System.out.println(myControl.getModel(0).getMyTurtle().getMyAngle());
        
//           Controller mySLogo = new Controller();
//           Canvas myView = new Canvas(mySLogo);
//       
    }

}
