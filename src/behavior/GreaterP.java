package behavior;

import slogo.Model;

/**
 * 
 * @author Richard Yang
 * 
 */

public class GreaterP extends TwoParameterCommand {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {

        return (getMyFirstValue() > getMySecondValue()) ? 1 : 0;
    }

}
