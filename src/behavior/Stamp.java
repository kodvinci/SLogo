package behavior;

import slogo.Model;


/**
 * Stamps turtle on display area
 * 
 * @author Jerry
 * 
 */
public class Stamp extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().createStamp
                (model.getController().getView().getTurtleArea().getMyTurtle(turtleNumber));
        return 0;
    }

}
