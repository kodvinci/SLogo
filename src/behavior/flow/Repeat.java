package behavior.flow;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.ParameterException;
import exceptions.SyntaxException;


/**
 * Repeat command
 * 
 * @author Richard Yang
 * 
 */
public class Repeat implements ICommand {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myRunTime;

    /**
     * constructor for repeat
     * 
     * @param subCommands command string
     * @param time run how many times
     * @param model model we want to operate
     * @throws NoSuchCommandException do not have such exceptions
     * @throws SyntaxException
     * @throws NumberFormatException
     * @throws NoSuchVariableException
     */
    public Repeat (String subCommands, int time, Model model)
                                                             throws NoSuchCommandException,
                                                             SyntaxException,
                                                             NoSuchVariableException {

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

    }

}
