package behavior;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.ParameterException;


/**
 * Tell turtles
 * 
 * @author jerrli2
 * 
 */
public class Tell implements ICommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;
    /**
     * parameter exception message
     */
    public static final String PARAMETER_EXCEPTION_MESSAGE = "parameter doesn't match";
    protected List<Integer> myActivatedTurtles;
    protected Parser myParser = new Parser();

    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        model.clearFutureActivatedTurtles();
        int last = 0;
        for (int i : myActivatedTurtles) {
            if (model.getMyTurtles().containsKey(i)) {
                model.addFutureActivatedTurtles(i);
            }
            else {
                model.addNewTurtle(i);
                model.addFutureActivatedTurtles(i);
                System.out.println("turtle doesn't exist, have to create : " + i);
            }
            System.out.println("turtle activated:" + i);
            last = i;
        }
        return last;
    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if (information.length != PARAMETER_NUMBER) { throw new ParameterException(
                                                                                   PARAMETER_EXCEPTION_MESSAGE); }
        myActivatedTurtles = new ArrayList<Integer>();
        String[] mySplitedContent = myParser.splitBlanksInsideBracket(information[0]);
        for (String str : mySplitedContent) {
            if (!myParser.judgeNumeric(str)) { throw new ParameterException(
                                                                            "Parameter doesn't match"); }
            myActivatedTurtles.add(Integer.parseInt(str));
        }
        System.out.println("activated turtle number :" + myActivatedTurtles.size());
    }

}
