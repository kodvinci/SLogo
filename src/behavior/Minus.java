package behavior;

import slogo.Model;


/**
 * Minus command
 * @author Richard Yang
 * 
 */

public class Minus extends OneParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {
        inverseMyValue();
        return getMyValue();
    }

}
