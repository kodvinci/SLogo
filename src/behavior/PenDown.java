package behavior;

import slogo.Model;


/**
 * Push pen down
 * 
 * @author Richard Yang
 * 
 */

public class PenDown extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().penDown();
        return 1;

    }

}
