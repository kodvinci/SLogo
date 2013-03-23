package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetHeading extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        double originAngle = model.getMyTurtle(turtleNumber).getAngle();
        model.getMyTurtle(turtleNumber).setAngle(getMyValue());
        return getMyValue() - originAngle;

    }

}
