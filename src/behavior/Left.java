package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Left extends OneParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        double angle = model.getMyTurtle(turtleNumber).getMyAngle();
        model.getMyTurtle(turtleNumber).setMyAngle(angle + getMyValue());
        return getMyValue();
    }
}
