package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Heading extends NoParameterCommand {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        return model.getMyTurtle(0).getAngle();
    }

}
