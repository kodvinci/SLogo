import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.CommandArea;
import view.DisplayArea;
import view.TurtleArea;


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

        // Interpreter myInter = new Interpreter();
        // myInter.process("FD 10 FD 10 BK 10 LT 90 FD 10");
        // System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getX());
        // System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getY());
        // System.out.println(myInter.getMyCommands().getMyModel().getMyTurtle().getMyAngle());

        JFrame myFrame = new JFrame(TITLE);
        JPanel myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE);
        myFrame.getContentPane().add(myTurtleArea, BorderLayout.CENTER);

        // for turtle status display
        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE);
        myFrame.getContentPane().add(myDisplay, BorderLayout.EAST);

        // for user input display
        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE);
        myFrame.getContentPane().add(myInput, BorderLayout.SOUTH);

        myFrame.pack();
        myFrame.setVisible(true);
    }

}
