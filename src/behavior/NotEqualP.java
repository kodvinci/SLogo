package behavior;

import slogo.Model;


/**
 * Not equal command
 * 
 * @author Richard Yang
 * 
 */

public class NotEqualP extends TwoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {
        return (getMyFirstValue() != getMySecondValue()) ? 1 : 0;
    }

}
