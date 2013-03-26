package behavior;

import slogo.Model;


/**
 * Get quotient of two parameters
 * @author Richard Yang
 * 
 */

public class Quotient extends TwoParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {
        int result = (int) getMyFirstValue() / (int) getMySecondValue();
        return result;
    }

}
