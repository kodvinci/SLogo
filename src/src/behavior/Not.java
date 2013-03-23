package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Not extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        return getMyValue() != 0 ? 0 : 1;
    }

}
