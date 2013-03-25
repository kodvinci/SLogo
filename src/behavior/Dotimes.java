package behavior;



import exceptions.ParameterException;
import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Dotimes extends Repeat {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 2;
    /**
     * the parameter number in first bracket
     */
    public static final int PARAMETER_IN_FIRST_BRACKET = 2;

    private Parser myParser = new Parser();
    private String myVariable;
    private int myStartValue;
    private int myEndValue;
    private int myStep;
    private List<ICommand> myBracketCommandsList;

    @Override
    public double move (Model model, int turtleNumber) throws Exception {

        for (ICommand c : myBracketCommandsList) {
            c.move(model, turtleNumber);

        }
        return 0;
    }

    

    /**
     * construct the command list in second bracket
     * @param secondBracket string in second bracket of dotimes command
     * @param model model we want to operate
     * @throws Exception several exceptions
     */

    public void construct (String secondBracket, Model model) throws Exception {

        String mySecondPrunedCommand = prune(secondBracket);
        for (int i = myStartValue; i < myEndValue + 1; i += myStep) {
            Double tmp = new Double(i);
            model.setVariableValue(myVariable, tmp);
            myBracketCommandsList.addAll(
                    myParser.buildMultipleCommands(
                                   myParser.split(mySecondPrunedCommand, model), model));
        }
        System.out.println(myBracketCommandsList.size());

    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if (information.length != PARAMETER_NUMBER) { 
            throw new ParameterException("parameter not match"); 
        }
        System.out.println("DOTimes Initialization Successful");
        myBracketCommandsList = new ArrayList<ICommand>();
        String[] mySplitedContent = myParser.splitBlanksInsideBracket(information[0]);
        if (mySplitedContent.length != PARAMETER_IN_FIRST_BRACKET ||
            !myParser.judgeNumeric(mySplitedContent[1])) { 
            throw new ParameterException("ParameterException");
        }
        myVariable = mySplitedContent[0];
        myStartValue = 0;
        myEndValue = Integer.parseInt(mySplitedContent[1]);
        myStep = 1;
        construct(information[1], model);
    }

}
