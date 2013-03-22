package behavior;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
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
    private int myValue;
    private String myBracketStringCommand;
    private String myPrunedStringCommands;
    private List<String[]> myBracketCommandsList; 
    private List<ICommand> myBracketCommands;

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
    public Repeat (String name, String value, String bracket, int time, Model model)
                                                             throws NoSuchCommandException,
                                                             SyntaxException,
                                                             NoSuchVariableException {
        myValue = Integer.parseInt(value); 
        myPrunedStringCommands = prune (bracket);
        myBracketCommandsList = createCommandsList(myPrunedStringCommands);
        myBracketCommands = createCommands(myBracketCommandsList);

    }
    
    public List<ICommand> createCommands (List<String[]> commands) {
        return null;
    }
    public List<String[]> createCommandsList (String commands) {
        return myParser.split(myPrunedStringCommands);
    }
    
    public String prune (String bracket) {
        return bracket.substring(1, bracket.length()-1);
    }

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        while (myValue > 0) {
            
        }
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {

    }

}
