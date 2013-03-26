package behavior;

import slogo.Model;

/**
 * 
 * @author Richard Yang
 * 
 */

public class And extends TwoParameterCommand {

    /**
     * the parameter number of this ceratin command
     */

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {

        return ((getMyFirstValue() != 0) && getMySecondValue() != 0) ? 1 : 0;
    }
}
