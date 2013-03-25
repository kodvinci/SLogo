package behavior;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.ParameterException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Dotimes extends Repeat {

    public static final int PARAMETER_NUMBER = 2;
    public static final int PARAMETER_IN_FIRST_BRACKET = 2;

    protected Parser myParser = new Parser();
    protected String myVariable;
    protected int myStartValue;
    protected int myEndValue;
    protected int myStep;
    protected List<ICommand> myBracketCommandsList;

    @Override
    public double move (Model model, int turtleNumber) throws Exception {

        for (ICommand c : myBracketCommandsList) {
            c.move(model, turtleNumber);
        }
        return 0;
    }

    public String[] splitFirstBracket (String myFirstPrunedCommand) {
        String[] myContent = myParser.getSpacePattern().split(myFirstPrunedCommand);
        List<String> buffer = new ArrayList<String>();
        for (int i = 0; i < myContent.length; i++) {
            if (!myParser.getSpacePattern().matcher(myContent[i]).matches() &&
                !myContent[i].equals("")) {
                buffer.add(myContent[i]);
            }
        }
        String[] myNewContent = new String[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            myNewContent[i] = buffer.get(i);
        }
        return myNewContent;
    }

    public void construct (String secondBracket, Model model) throws Exception {

        String mySecondPrunedCommand = prune(secondBracket);
        for (int i = myStartValue; i < myEndValue + 1; i += myStep) {
            Double tmp = new Double(i);
            model.setVariableValue(myVariable, tmp);
            myBracketCommandsList.addAll(myParser.buildMultipleCommands(myParser
                    .split(mySecondPrunedCommand, model), model));
        }
        System.out.println(myBracketCommandsList.size());

    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if (information.length != PARAMETER_NUMBER) { throw new ParameterException(
                                                                                   "parameter not match"); }
        System.out.println("DOTimes Initialization Successful");
        myBracketCommandsList = new ArrayList<ICommand>();
        String myFirstPrunedCommand = prune(information[0]);
        System.out.println(myFirstPrunedCommand);
        String[] mySplitedContent = splitFirstBracket(prune(myFirstPrunedCommand));
        if (mySplitedContent.length != PARAMETER_IN_FIRST_BRACKET ||
            !myParser.judgeNumeric(mySplitedContent[1])) { throw new ParameterException(
                                                                                        "ParameterException"); }
        myVariable = mySplitedContent[0];
        myStartValue = 0;
        myEndValue = Integer.parseInt(mySplitedContent[1]);
        myStep = 1;
        construct(information[1], model);
    }

}
