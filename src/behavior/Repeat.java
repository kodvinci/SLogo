package behavior;

import java.util.List;
import slogo.Model;
import slogo.Parser;


/**
 * Repeat command
 * 
 * @author Richard Yang
 * 
 */
public class Repeat implements ICommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 2;

    private Parser myParser = new Parser();
    private int myValue;
    private String myPrunedStringCommands;
    private List<String[]> myListOfCommands;
    private List<ICommand> myBracketCommandsList;

    /**
     * Construct commands from bracket
     * 
     * @param value repeat number
     * @param bracket commands in bracket
     * @param model model
     * @throws Exception exception
     */
    public void construct (String value, String bracket, Model model) throws Exception {
        myValue = Integer.parseInt(value);
        myPrunedStringCommands = myParser.prune(bracket);
        myBracketCommandsList = createCommandsList(myPrunedStringCommands, model);

    }

    /**
     * Creates list of commands
     * 
     * @param commands commands
     * @param model model
     * @return
     * @throws Exception exception
     */
    public List<ICommand> createCommandsList (String commands, Model model) throws Exception {
        myListOfCommands = myParser.split(myPrunedStringCommands, model);
        return myParser.buildMultipleCommands(myListOfCommands, model);
    }

    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        int count = 0;
        while (count < myValue) {

            myBracketCommandsList = createCommandsList(myPrunedStringCommands, model);

            for (int i = 0; i < myBracketCommandsList.size(); i++) {
                System.out.println("Is repeat repeating? " + myValue);
                myBracketCommandsList.get(i).move(model, turtleNumber);
            }
            model.addVariable(":repcount", Integer.toString(count));
            count++;
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
        System.out.println("REPEAT Initialization Successful");
        construct(information[0], information[1], model);
    }

}
