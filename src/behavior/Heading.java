package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Heading extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        return model.getMyTurtle(0).getAngle();
    }

}
