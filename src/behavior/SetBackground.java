package behavior;

import slogo.Model;


/**
 * Set background color
 * 
 * @author Jerry
 * 
 */
public class SetBackground extends OneParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().changeBackgroundColor((int) getMyValue());
        return 0;
    }

}
