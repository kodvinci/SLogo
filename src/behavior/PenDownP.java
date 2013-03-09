package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class PenDownP extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return model.getMyTurtle(turtleNumber).isLeaveTrail() ? 1 : 0;
    }

}
