package behavior;

import slogo.Model;


/**
 * Set pen size
 * 
 * @author Jerry
 * 
 */
public class SetPenSize extends OneParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().editPenWidth((int) getMyValue());
        return 0;
    }

}
