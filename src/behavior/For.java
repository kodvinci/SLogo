package behavior;

import java.util.ArrayList;
import slogo.Model;
import exceptions.ParameterException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class For extends Dotimes {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 2;
    /**
     * the parameter number in first bracket
     */
    public static final int PARAMETER_IN_FIRST_BRACKET = 4;

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if (information.length != PARAMETER_NUMBER) { throw new ParameterException(
                                                                                   "parameter not match"); }
        System.out.println("DOTimes Initialization Successful");
        myBracketCommandsList = new ArrayList<ICommand>();
        String[] mySplitedContent = myParser.splitBlanksInsideBracket(information[0]);
        if (mySplitedContent.length != PARAMETER_IN_FIRST_BRACKET ||
            !myParser.judgeNumeric(mySplitedContent[1])
            || !myParser.judgeNumeric(mySplitedContent[2]) ||
            !myParser.judgeNumeric(mySplitedContent[PARAMETER_IN_FIRST_BRACKET - 1])) { throw new ParameterException(
                                                                                                                     "ParameterException"); }
        myVariable = mySplitedContent[0];
        myStartValue = Integer.parseInt(mySplitedContent[1]);
        myEndValue = Integer.parseInt(mySplitedContent[2]);
        myStep = Integer.parseInt(mySplitedContent[PARAMETER_IN_FIRST_BRACKET - 1]);
        construct(information[1], model);
    }
}
