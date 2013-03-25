package behavior;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.ParameterException;


/**
 * if command
 * 
 * @author Richard Yang
 * 
 */
public class If implements ICommand {

    public static final int PARAMETER_NUMBER = 2;
    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myStatement;
    private String myPrunedStringCommands;
    private List<String[]> myListOfCommands;

    public If () {

    }

    public static int getParameterNumber () {
        return PARAMETER_NUMBER;
    }

    public void construct (String value, String bracket, Model model) throws Exception {
        if (!myParser.getNumPattern().matcher(value).matches()) { throw new ParameterException(
                                                                                               "parameterException"); }
        myStatement = Integer.parseInt(value);
        myPrunedStringCommands = prune(bracket);
        myCommands = createCommandsList(myPrunedStringCommands, model);

    }

    public String prune (String bracket) {
        return bracket.substring(1, bracket.length() - 1);
    }

    public List<ICommand> createCommandsList (String commands, Model model) throws Exception {
        myListOfCommands = myParser.split(myPrunedStringCommands, model);
        return myParser.buildMultipleCommands(myListOfCommands, model);
    }

    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        if (myStatement != 0) {
            for (ICommand command : myCommands) {
                command.move(model, turtleNumber);
            }
        }
        if (model.getUserVariables()
                .containsKey(myListOfCommands.get(myListOfCommands.size() - 1)[1])) {
            return Double.parseDouble(model.getUserVariables().get(myListOfCommands
                    .get(myListOfCommands
                            .size() - 1)[1]));
        }
        else {
            return Double.parseDouble(myListOfCommands.get(myListOfCommands.size() - 1)[1]);
        }
    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        System.out.println("IF initialization successful");
        construct(information[0], information[1], model);
    }

}
