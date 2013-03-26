package behavior;

import slogo.Model;

/**
 * Set pen color
 * @author Jerry
 *
 */
public class SetPenColor extends OneParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().setPenColor((int) getMyValue());
        return 0;
    }
}
