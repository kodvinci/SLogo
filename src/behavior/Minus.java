package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Minus extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {
        inverseMyValue();
        return getMyValue();
    }

}
