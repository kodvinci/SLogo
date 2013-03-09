package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class PenUp extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        model.getMyTurtle(turtleNumber).leftTrail();
        return 0;

    }

}
