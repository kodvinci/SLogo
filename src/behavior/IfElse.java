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
 * Implements IFELSE statement
 * 
 * @author Jerry Li
 * 
 */
public class IfElse implements ICommand {

    /**
     * Resources for commands
     */
    public static final int PARAMETER_NUMBER = 3;
    private List<String[]> myStringTrueCommands;
    private List<String[]> myStringFalseCommands;
    private List<ICommand> myTrueCommands;
    private List<ICommand> myFalseCommands;
    private Parser myParser = new Parser();
    private double myValue;
    private double myFinalValue;

    /**
     * Constructs the command
     * 
     * @param trueCommands commands in true bracket
     * @param falseCommands commands in false bracket
     * @param value value
     * @throws Exception
     */
    public void construct (String value, String firstBracket, String secondBracket,
                           Model model) throws Exception {

        if (!myParser.getNumPattern().matcher(value).matches()) { throw new ParameterException(
                                                                                               "ParameterException"); }
        parse(value, firstBracket, secondBracket, model);
        // myStringTrueCommands = trueCommands;
        // myStringFalseCommands = falseCommands;
        myTrueCommands = new ArrayList<ICommand>();
        myFalseCommands = new ArrayList<ICommand>();

        map(myStringTrueCommands, myStringFalseCommands, model);
    }

    public void parse (String value, String firstBracket, String secondBracket, Model model)
                                                                                            throws Exception {
        if (!myParser.getNumPattern().matcher(value).matches()) { throw new ParameterException(
                                                                                               "ParameterException"); }
        String firstBracketPruned = firstBracket.substring(1, firstBracket.length() - 1);
        String secondBracketPruned = secondBracket.substring(1, secondBracket.length() - 1);

        // System.out.println("first without brackets " + firstBracketPruned);
        // System.out.println("second without brackets " + secondBracketPruned);
        myStringTrueCommands = myParser.split(firstBracketPruned, model);
        myStringFalseCommands = myParser.split(secondBracketPruned, model);
        myValue = Double.parseDouble(value);

    }

    /**
     * return final value
     * 
     * @return
     */
    public double getMyFinalValue () {
        return myFinalValue;
    }

    /**
     * Map to respective lists
     * 
     * @param trueCommands true commands
     * @param falseCommands false commands
     * @throws Exception
     */
    public void map (List<String[]> trueCommands, List<String[]> falseCommands, Model model)
                                                                                            throws Exception {
        myTrueCommands = buildCommands(trueCommands, model);
        myFalseCommands = buildCommands(falseCommands, model);
    }

    /**
     * Build ICommands from list of string commands
     * 
     * @param commands commands
     * @return
     * @throws NoSuchCommandException
     * @throws SyntaxException
     * @throws NoSuchVariableException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public List<ICommand> buildCommands (List<String[]> commands, Model model)
                                                                              throws Exception {
        List<ICommand> theCommands = myParser.buildMultipleCommands(commands, model);
        return theCommands;
    }

    /**
     * Moves the turtle
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @throws Exception
     * 
     */
    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        myFinalValue = move(model, turtleNumber, myValue);
        return myFinalValue;
    }

    /**
     * Moves turtle with value
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @param value the value
     * @return
     * @throws Exception
     */
    public double move (Model model, int turtleNumber, double value) throws Exception {
        if (value == 0) {
            for (int i = 0; i < myFalseCommands.size(); i++) {
                myFalseCommands.get(i).move(model, turtleNumber);
                System.out.println(myFalseCommands.size());
            }
            if (model.getUserVariables().containsKey(myStringFalseCommands.get(myStringFalseCommands

                                                             .size() - 1)[1])) {

                return Double.parseDouble(model.getUserVariables()
                        .get(myStringFalseCommands.get(myStringFalseCommands.size() - 1)[1]));
            }
            else {
                return Double
                        .parseDouble(myStringFalseCommands.get(myStringFalseCommands.size() - 1)[1]);
            }
        }
        else {
            for (int i = 0; i < myTrueCommands.size(); i++) {
                myTrueCommands.get(i).move(model, turtleNumber);
            }
            if (model.getUserVariables().containsKey(myStringTrueCommands.get(myStringTrueCommands
                                                             .size() - 1)[1])) {

                return Double.parseDouble(model.getUserVariables()
                        .get(myStringTrueCommands.get(myStringTrueCommands.size() - 1)[1]));
            }
            else {
                return Double
                        .parseDouble(myStringTrueCommands.get(myStringTrueCommands.size() - 1)[1]);
            }
        }

    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        System.out.println("initialize successful");
        System.out.println("subarray size" + information.length);
        construct(information[0], information[1], information[2], model);
    }

}
