package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Quotient extends TwoParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {
        int result = (int) getMyFirstValue() / (int) getMySecondValue();
        return result;
    }

}
