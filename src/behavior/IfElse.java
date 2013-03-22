package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
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
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    public static final int PARAMETER_NUMBER = 3;
    private List<String[]> myStringTrueCommands;
    private List<String[]> myStringFalseCommands;
    private List<ICommand> myTrueCommands;
    private List<ICommand> myFalseCommands;
    private Parser myParser = new Parser();
    private double myValue;
    private double myFinalValue;

    
    

    private ResourceBundle myResources;


    /**
     * Constructs the command
     * 
     * @param trueCommands commands in true bracket
     * @param falseCommands commands in false bracket
     * @param value value
     * @throws NoSuchCommandException
     * @throws SyntaxException
     * @throws NoSuchVariableException 
     */
    public void construct (String value, String firstBracket, String secondBracket,
                   Model model)
                               throws NoSuchCommandException, SyntaxException, NoSuchVariableException {
        
        parse(value, firstBracket, secondBracket, model);
//        myStringTrueCommands = trueCommands;
//        myStringFalseCommands = falseCommands;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myTrueCommands = new ArrayList<ICommand>();
        myFalseCommands = new ArrayList<ICommand>();
        
        map(myStringTrueCommands, myStringFalseCommands, model);
    }
    public IfElse () {
          
    }
    
  
    public void parse(String value, String firstBracket, String secondBracket, Model model) {
        String firstBracketPruned = firstBracket.substring(1, firstBracket.length()-1);
        String secondBracketPruned = secondBracket.substring(1, secondBracket.length()-1);
        
//        System.out.println("first without brackets " + firstBracketPruned);
//        System.out.println("second without brackets " + secondBracketPruned);
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
     * @throws NoSuchCommandException
     * @throws SyntaxException
     * @throws NoSuchVariableException 
     */
    public void map (List<String[]> trueCommands, List<String[]> falseCommands, Model model)
                                                                                            throws NoSuchCommandException,
                                                                                            SyntaxException, NoSuchVariableException {
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
     */
    public List<ICommand> buildCommands (List<String[]> commands, Model model)
                                                                              throws NoSuchCommandException,
                                                                              SyntaxException, NoSuchVariableException {
        List<ICommand> theCommands = myParser.buildMultipleCommands(commands, model);
        return theCommands;
    }

    /**
     * Moves the turtle
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @throws SyntaxException SyntaxException
     * 
     */
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
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
     * @throws SyntaxException SyntaxException
     */
    public double move (Model model, int turtleNumber, double value) throws SyntaxException {
        if (value == 0) {
            for (int i = 0; i < myFalseCommands.size(); i++) {
                myFalseCommands.get(i).move(model, turtleNumber);
                System.out.println(myFalseCommands.size());
            }
            return Double.parseDouble(myStringFalseCommands.get(myStringFalseCommands.size() - 1)[1]);
        }
        else {
            for (int i = 0; i < myTrueCommands.size(); i++) {
                myTrueCommands.get(i).move(model, turtleNumber);
            }
            return Double.parseDouble(myStringTrueCommands.get(myStringTrueCommands.size()-1)[1]);
        }

    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException, NoSuchCommandException, NoSuchVariableException {
        System.out.println("initialize successful");
        System.out.println("subarray size" + information.length);
        construct(information[0], information[1], information[2], model);
    }

}
