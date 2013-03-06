package behavior;

import java.util.ResourceBundle;
import slogo.Model;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class CommandEntities {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

    private ResourceBundle myResources;

    /**
     * constructor
     * 
     * @param bundleName the name of resource bundle which include command information
     */
    public CommandEntities (String bundleName) {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + bundleName);
    }

    /**
     * 
     <<<<<<< HEAD
     * 
     * @param model SLogo model
     * @param commandName String of command
     * @param parameters parameters
     * @throws SyntaxException Syntax Exception
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     *         =======
     * @param model model which we want deal with
     * @param command name of the command
     * @param parameters parameters of this command
     * @throws SyntaxException
     * @throws NoSuchCommandException
     *         >>>>>>> 7bd5c8816a7f4ca84214b88b0f22592b425a1a74
     */
    public void doCommand (Model model, String command,
                           double[] parameters) throws SyntaxException, NoSuchCommandException {
        if (!myResources.containsKey(command)) {
            throw new NoSuchCommandException();
        }
        else {
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
            ICommand myCommand = (ICommand) o;
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
