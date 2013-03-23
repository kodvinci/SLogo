package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class PenDownP extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        return model.getMyTurtle(turtleNumber).isLeaveTrail() ? 1 : 0;
    }

}
