package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Or extends TwoParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {

        return ((getMyFirstValue() == 0) && (getMySecondValue() == 0)) ? 0 : 1;
    }

}
