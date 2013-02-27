import java.awt.Dimension;
import utilities.Controller;
import view.Canvas;


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
       
         Controller myController = new Controller();
         
         Canvas myView = new Canvas(myController);
         
         System.out.println(myController.getMyModels().size());
       //  myController.processUserInput(0,"FD 10 FD 10 BK 10 LT 90");
         System.out.println(myController.getModel(0).getMyTurtle().getX());
         System.out.println(myController.getModel(0).getMyTurtle().getY());
         System.out.println(myController.getModel(0).getMyTurtle().getMyAngle());

         
         

//         System.out.println("start");
//       
//         Controller myControl = new Controller();
//         
//         System.out.println(myControl.getMyModels().size());
//         myControl.processUserInput(0,"FD 10 FD 10 BK 10 LT 90");
//         System.out.println(myControl.getModel(0).getMyTurtle().getX());
//         System.out.println(myControl.getModel(0).getMyTurtle().getY());
//         System.out.println(myControl.getModel(0).getMyTurtle().getMyAngle());
        
        //   Controller mySLogo = new Controller();
        //   Canvas myView = new Canvas(mySLogo);
//       

    }

}
