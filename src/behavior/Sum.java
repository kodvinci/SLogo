package behavior;

import slogo.Model;


/**
 * Commands with two parameters
 * @author Richard Yang
 * 
 */

public class Sum extends TwoParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {

        return getMyFirstValue() + getMySecondValue();
    }

}
