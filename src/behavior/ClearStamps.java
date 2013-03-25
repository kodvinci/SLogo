package behavior;

import slogo.Model;


/**
 * class used for create stamps on turtles
 * 
 * @author Richard Yang, Jerry Li
 * 
 */

public class ClearStamps extends NoParameterCommand {

    /**
     * the parameter number of this ceratin command
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().clearStamps();
        return 0;
    }

}
