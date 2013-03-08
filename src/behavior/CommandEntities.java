package behavior;

import java.util.List;
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

    
    
    public void doCommand (Model model, int turtleNumber , List<ICommand> commands) throws SyntaxException  {
        for(ICommand command : commands){
            command.move(model, turtleNumber);
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
