package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetHeading extends OneParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        double originAngle = model.getMyTurtle(turtleNumber).getMyAngle();
        model.getMyTurtle(turtleNumber).setMyAngle(getMyValue());
        return getMyValue() - originAngle;

    }

}
