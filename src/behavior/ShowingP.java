package behavior;

import slogo.Model;


/**
 * Return if turtle is showing
 * @author Richard Yang
 * 
 */

public class ShowingP extends NoParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        return model.getMyTurtle(turtleNumber).isVisible() ? 1 : 0;
    }

}
