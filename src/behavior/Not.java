package behavior;

import slogo.Model;


/**
 * Not command
 * @author Richard Yang
 * 
 */

public class Not extends OneParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        return getMyValue() != 0 ? 0 : 1;
    }

}
