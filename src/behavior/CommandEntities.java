package behavior;

import exceptions.SyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class CommandEntities {
    
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources."; 

    private ResourceBundle myResources;
    
    private Map<String, ICommand> myCommands;

    /**
     * New CommandEntities
     */
    public CommandEntities () {
        myCommands = new HashMap<String, ICommand>();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
    }

    /**
     * add a command
     * 
     * @param command String name of command
     * @param newCommand The ICommand
     */
    public void addCommand (String command, ICommand newCommand) {
        myCommands.put(command, newCommand);
    }

    /**
     * Removes command
     * 
     * @param command string command
     */
    public void removeCommand (String command) {
        myCommands.remove(command);
    }

    /**
     * initialize commands
     */
    public void initialize () {
       
    }

    /**
     * get command
     * 
     * @param command String command
     * @return ICommand
     * @throws SyntaxException Syntax exception
     */
    public ICommand getCommand (String command) throws SyntaxException {
        if (!myCommands.containsKey(command)) {
            throw new SyntaxException();
        }

        return myCommands.get(command);
    }

    /**
     * perform command
     * 
     * @param model SLogo model
     * @param commandName String of command
     * @param parameters parameters
     * @throws SyntaxException Syntax Exception
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public void doCommand (Model model, String command,
                           double[] parameters) throws SyntaxException {
        if( !myResources.containsKey(command)) throw new SyntaxException();
        else{
            String commandName = myResources.getString(command);
            Class<?> commandClass = null;
            try {
                commandClass = Class.forName("behavior." + commandName);
            }
            catch (ClassNotFoundException e) {
                System.out.println("command not found");
            }
            Object o = null;
            try {
                o = commandClass.newInstance();
            }
            catch (InstantiationException | IllegalAccessException e) {
                System.out.println("cannot create instance");
            }
            ICommand myCommand = (ICommand)o;
            myCommand.move(model.getMyTurtle(0), parameters);
               
        }
    }

    /**
     * invert
     * 
     * @param parameters parameters
     * @return inverted parameters
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
