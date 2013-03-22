package behavior;

import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;


/**
 * Repeat command
 * 
 * @author Richard Yang
 * 
 */
public class Repeat implements ICommand {
    
    public static final int PARAMETER_NUMBER = 3;

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

    private Parser myParser = new Parser();
    private int myValue;
    private String myPrunedStringCommands;
    private List<String[]> myListOfCommands;
    private List<ICommand> myBracketCommandsList;

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
    public Repeat () {

    }

    public void construct (String value, String bracket, Model model)
                                                                     throws NoSuchCommandException,
                                                                     SyntaxException,
                                                                     NoSuchVariableException,
                                                                     NoSuchFieldException,
                                                                     SecurityException,
                                                                     IllegalArgumentException,
                                                                     IllegalAccessException {
        myValue = Integer.parseInt(value);
        myPrunedStringCommands = prune(bracket);
        //myBracketCommandsList = createCommandsList(myPrunedStringCommands, model);

    }

    public List<ICommand> createCommandsList (String commands, Model model) throws SyntaxException,
                                                                           NoSuchCommandException,
                                                                           NoSuchVariableException,
                                                                           NoSuchFieldException,
                                                                           SecurityException,
                                                                           IllegalArgumentException,
                                                                           IllegalAccessException {
        myListOfCommands = myParser.split(myPrunedStringCommands, model);
        return myParser.buildMultipleCommands(myListOfCommands, model);
    }

    public String prune (String bracket) {
        return bracket.substring(1, bracket.length() - 1);
    }

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchCommandException, NoSuchVariableException {
        while (myValue > 0) {
            try {
                myBracketCommandsList = createCommandsList(myPrunedStringCommands, model);
            }
            catch (NoSuchCommandException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            for (int i = 0; i < myBracketCommandsList.size(); i++) {
                System.out.println("Is repeat repeating? " + myValue);
                myBracketCommandsList.get(i).move(model, turtleNumber);
            }
            myValue--;
        }
        return Double.parseDouble(myListOfCommands.get(myListOfCommands.size() - 1)[1]);
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException,
                                                              NoSuchCommandException,
                                                              NoSuchVariableException,
                                                              NoSuchFieldException,
                                                              SecurityException,
                                                              IllegalArgumentException,
                                                              IllegalAccessException {
        System.out.println("REPEAT Initialization Successful");
        construct(information[0], information[1], model);
    }

}
