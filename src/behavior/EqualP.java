package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class EqualP extends TwoParameterCommand {

    /**
     * the parameter number of this ceratin command
     */

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {
        return (getMyFirstValue() == getMySecondValue()) ? 1 : 0;
    }

}
