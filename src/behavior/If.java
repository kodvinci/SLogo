package behavior;

import exceptions.ParameterException;
import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;


/**
 * if command
 * 
 * @author Richard Yang
 * 
 */
public class If implements ICommand {
    
    /**
     * Number of parameters commands take
     */
    public static final int PARAMETER_NUMBER = 2;
    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myStatement;
    private String myPrunedStringCommands;
    private List<String[]> myListOfCommands;

    /**
     * Returns parameter number
     * @return
     */
    public static int getParameterNumber () {
        return PARAMETER_NUMBER;
    }
    
    /**
     * Construct commands from bracket
     * @param value     value
     * @param bracket   commands in bracket
     * @param model     model
     * @throws Exception        exception
     */
    public void construct (String value, String bracket, Model model) throws Exception {
        if (!myParser.getNumPattern().matcher(value).matches()) { 
            throw new ParameterException("parameterException"); 
        }
        myStatement = Integer.parseInt(value);
        myPrunedStringCommands = myParser.prune(bracket);
        myCommands = createCommandsList(myPrunedStringCommands, model);

    }

  
    /**
     * create list of commands
     * @param commands  commands in bracket
     * @param model     model
     * @return
     * @throws Exception exceptions
     */
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
