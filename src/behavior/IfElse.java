package behavior;

import exceptions.ParameterException;
import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;


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
    private List<ICommand> myCommands;
    private Parser myParser = new Parser();
    private int myValue;
    private double myFinalValue;
    private String myParameterExceptionMessage = "Parameter Exception";

    /**
     * Constructs false commands and true commands
     * @param value             value after IFELSE 
     * @param firstBracket      true commands
     * @param secondBracket     false commands
     * @param model             model
     * @throws Exception        exception
     */
    public void construct (String value, String firstBracket, String secondBracket,
                           Model model) throws Exception {

        if (!myParser.getNumPattern().matcher(value).matches()) { 
            throw new ParameterException(myParameterExceptionMessage); 
        }
        parse(value, firstBracket, secondBracket, model);
        myCommands = new ArrayList<ICommand>();

        mapTrueCommandsAndFalseCommands(myStringTrueCommands, myStringFalseCommands, model, myValue);
    }
    
    /**
     * Get rid of extra brackets and spaces
     * @param value             value after IFELSE
     * @param firstBracket      true commands
     * @param secondBracket     false commands
     * @param model             model
     * @throws Exception        Exception
     */
    public void parse (String value, String firstBracket, String secondBracket, 
                       Model model) throws Exception {
        
        if (!myParser.getNumPattern().matcher(value).matches()) { 
            throw new ParameterException("ParameterException"); 
        }
        String firstBracketPruned = myParser.prune(firstBracket);
        String secondBracketPruned = myParser.prune(secondBracket);
        myStringTrueCommands = myParser.split(firstBracketPruned, model);
        myStringFalseCommands = myParser.split(secondBracketPruned, model);
        myValue = Integer.parseInt(value);

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
     * Build commands and put them in respective list
     * @param trueCommands      true commands
     * @param falseCommands     false commands
     * @param model             model
     * @param value             value
     * @throws Exception        Exception
     */
    public void mapTrueCommandsAndFalseCommands (List<String[]> trueCommands, 
                                                 List<String[]> falseCommands, 
                                                 Model model, int value) throws Exception {

        if (value == 1) {  
            myCommands = buildCommands(trueCommands, model);
        }
        else if (value == 0) {
            myCommands = buildCommands(falseCommands, model);
        }
    }

    /**
     * build commands from list
     * @param commands  commands
     * @param model     model
     * @return  
     * @throws Exception        exception
     */
    public List<ICommand> buildCommands (List<String[]> commands, 
                                         Model model) throws Exception {
        List<ICommand> theCommands = myParser.buildMultipleCommands(commands, model);
        return theCommands;
    }

    /**
     * Moves the turtle
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @throws Exception        exception
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
     * @throws Exception        exception
     */
    public double move (Model model, int turtleNumber, double value) throws Exception {

        for (int i = 0; i < myCommands.size(); i++) {
            myCommands.get(i).move(model, turtleNumber);
        }
        if (model.getUserVariables().containsKey(myStringTrueCommands.get
                                                 (myStringTrueCommands.size() - 1)[1])) {

            return Double.parseDouble(model.getUserVariables().get
                                      (myStringTrueCommands.get(myStringTrueCommands.size() - 1)[1]));
        }
        else {
            return Double.parseDouble(myStringTrueCommands.get(myStringTrueCommands.size()
                                                          - 1)[1]);
        }


    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        System.out.println("initialize successful");
        System.out.println("subarray size" + information.length);
        construct(information[0], information[1], information[2], model);
    }

}
