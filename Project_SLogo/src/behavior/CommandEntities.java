package behavior;

import exceptions.SyntaxException;
import java.util.HashMap;
import java.util.Map;
import utilities.Model;

/**
 * 
 * @author Richard Yang
 * 
 */

public class CommandEntities {

    private static final String FORWARD = "FD";

    private static final String BACK = "BK";

    private static final String LEFT = "LT";

    private static final String RIGHT = "RT";

    private static final String SETHEADING = "SETH";

    private static final String TOWARDS = "TOWARDS";

    private static final String SETXY = "SETXY";

    private static final String PENDOWN = "PD";

    private static final String PENUP = "PU";

    private static final String SHOWTURTLE = "ST";

    private static final String HIDETURTLE = "HT";

    private static final String HOME = "HOME";

    private static final String CLEARSCREEN = "CS";

    private Map<String, ICommand> myCommands;
    
    /**
     * New CommandEntities
     */
    public CommandEntities () {
        myCommands = new HashMap<String, ICommand>();
    }
    
    /**
     * add a command
     * @param command           String name of command
     * @param newCommand        The ICommand
     */
    public void addCommand (String command, ICommand newCommand) {
        myCommands.put(command, newCommand);
    }
    
    /**
     * Removes command
     * @param command   string command
     */
    public void removeCommand (String command) {
        myCommands.remove(command);
    }
    
    /**
     * initialize commands
     */
    public void initialize () {
        addCommand(FORWARD, new Forward());
        addCommand(BACK, new Back());
        addCommand(LEFT, new Left());
        addCommand(RIGHT, new Right());
        addCommand(SETHEADING, new SetHeading());
        addCommand(TOWARDS, new Towards());
        addCommand(SETXY, new SetXY());
        addCommand(PENDOWN, new PenDown());
        addCommand(PENUP, new PenUp());
        addCommand(SHOWTURTLE, new ShowTurtle());
        addCommand(HIDETURTLE, new HideTurtle());
        addCommand(HOME, new Home());
        addCommand(CLEARSCREEN, new ClearScreen());
    }
    
    /**
     * get command
     * @param command   String command
     * @return          ICommand
     * @throws SyntaxException  Syntax exception
     */
    public ICommand getCommand (String command) throws SyntaxException {
        if (!myCommands.containsKey(command)) { 
            throw new SyntaxException();
        }

        return myCommands.get(command);
    }
    
    /**
     * perform command
     * @param model             SLogo model
     * @param commandName       String of command
     * @param parameters        parameters
     * @throws SyntaxException  Syntax Exception
     */
    public void doCommand (Model model, String commandName, 
                           double[] parameters) throws SyntaxException {
        ICommand command = getCommand(commandName);

        command.move(model.getMyTurtle(), parameters);
    }
    
    /**
     * invert
     * @param parameters        parameters
     * @return                  inverted parameters
     */
    public static double[] inverse (double[] parameters) {
        int length = parameters.length;
        double[] inverseParameters = new double[length];
        for (int i = 0; i < length; i++) {
            inverseParameters[i] = -parameters[i];
        }
        return inverseParameters;
    }

}
