import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import utilities.Interpreter;
import view.CommandArea;
import view.DisplayArea;
import view.TurtleArea;

/**
 * 
 * @author Leonard
 *
 */
public class Main {

    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 600);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 600);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 50);
    public static final String TITLE = "SLOGO";

    /**
     * @param args
     */
    public static void main (String[] args) {

          Interpreter myInter = new Interpreter(); 
          myInter.process("FD 10 FD 10 BK 10 LT 90 FD 10");
          System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getX());
          System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getY());
          System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getMyAngle());
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
//        JFrame myWindow = new JFrame(TITLE);
//        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myWindow.setVisible(true);
//
//        // for turtle sprite display
//        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE);
//        myWindow.getContentPane().add(myTurtleArea, BorderLayout.CENTER);
//
//        // for turtle status display
//        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE);
//        myWindow.getContentPane().add(myDisplay, BorderLayout.EAST);
//
//        // for input commands
//        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE);
//        myWindow.getContentPane().add(myInput, BorderLayout.SOUTH);
//
//        myWindow.pack();
//        
    }

}
