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

    public static final int PARAMETER_NUMBER = 2;

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
     * @throws Exception
     * */
    public Repeat () {

    }

    public void construct (String value, String bracket, Model model)
                                                                     throws Exception {
        myValue = Integer.parseInt(value);
        myPrunedStringCommands = prune(bracket);
        myBracketCommandsList = createCommandsList(myPrunedStringCommands, model);

    }

    public List<ICommand> createCommandsList (String commands, Model model) throws Exception {
        myListOfCommands = myParser.split(myPrunedStringCommands, model);
        return myParser.buildMultipleCommands(myListOfCommands, model);
    }

    public String prune (String bracket) {
        return bracket.substring(1, bracket.length() - 1);
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
