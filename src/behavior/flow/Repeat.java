package behavior.flow;


import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;

/**
 * Repeat command
 * @author Richard Yang
 *
 */
public class Repeat implements ICommand {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    
    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myRunTime;
    private ResourceBundle myResources;
    
    
    
    /**
     * constructor for repeat 
     * @param subCommands command string
     * @param time run how many times
     * @param model model we want to operate
     * @throws NoSuchCommandException do not have such exceptions
     * @throws SyntaxException 
     * @throws NumberFormatException
     * @throws NoSuchVariableException
     */
    public Repeat(String subCommands, int time, Model model) 
            throws NoSuchCommandException, SyntaxException,  NoSuchVariableException{
        
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
       
        myRunTime = time;
         
        myParser.parseOneBracket(subCommands, myCommands, model);
        
        
    }
    
    
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double returnValue = 0;
        int time = myRunTime;
        while (time != 0) {
            for (ICommand command : myCommands) {
                returnValue = command.move(model, turtleNumber);
            }
            time--;
        }
        return returnValue;
    }



    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        // TODO Auto-generated method stub
        
    }

}
