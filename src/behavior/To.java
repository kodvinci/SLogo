package behavior;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;


/**
 * Implements TO command
 * 
 * @author Jerry
 * 
 */
public class To implements ICommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 3;
    private List<ICommand> myCommandList = new ArrayList<ICommand>();
    private String[] myVariables;
    private String[] myCommands;
    private String myName;
    private Parser myParser = new Parser();

    /**
     * Construct commands from bracketed variables and commands
     * 
     * @param value name of command
     * @param firstBracket variables
     * @param secondBracket commands
     * @param model model
     * @throws Exception Exception
     */
    public void construct (String value, String firstBracket, String secondBracket,
                           Model model) throws Exception {

        parse(firstBracket, secondBracket);
        mapParameterToCommand(myVariables, myCommands, model);
        model.addUserCommands(value, this);
    }

    /**
     * Checks to see if there are same number of variables and commands
     * 
     * @return
     */
    public int checkLegal () {
        if (myVariables.length == myCommands.length) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Parse extra spaces and brackets
     * 
     * @param firstBracket variables
     * @param secondBracket commands
     */
    public void parse (String firstBracket, String secondBracket) {

        // String firstBracketPruned = firstBracket.substring(1, firstBracket.length() - 1);
        // String secondBracketPruned = secondBracket.substring(1, secondBracket.length() - 1);
        myVariables = myParser.splitBlanksInsideBracket(firstBracket);
        myCommands = myParser.splitBlanksInsideBracket(secondBracket);

    }

    /**
     * return name
     * 
     * @return
     */
    public String getName () {
        return myName;
    }

    /**
     * Maps variable to command, creating the command and adding it to a list
     * 
     * @param variables variables
     * @param commands commands
     * @param model model
     * @throws Exception exception
     */
    public void mapParameterToCommand (String[] variables, String[] commands,
                                       Model model) throws Exception {
        if (checkLegal() == 0) { throw new NoSuchCommandException(); }
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            // System.out.println(Arrays.toString(command));
            String variable = variables[i];
            // System.out.println(Arrays.toString(variable));

            String[] str = { command, variable };
            ICommand myCommand = myParser.buildCommand(str, model);
            myCommandList.add(myCommand);
            model.addVariable(":TO" + Integer.toString(i), variable);
            // System.out.println(myCommandList.size());
        }
    }

    /**
     * Move
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @throws Exception exception
     */
    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        for (int i = 0; i < myCommandList.size(); i++) {
            myCommandList.get(i).move(model, turtleNumber);
        }

        return checkLegal();
    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        System.out.println("initialize successful");
        System.out.println("subarray size" + information.length);
        construct(information[0], information[1], information[2], model);
    }

}
