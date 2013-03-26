package behavior;

import slogo.Model;


/**
 * Pull pen up
 * 
 * @author Jerry
 * 
 */

public class PenUp extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().penUp();
        return 0;

    }

}
