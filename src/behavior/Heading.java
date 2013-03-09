package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Heading extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        return model.getMyTurtle(0).getMyAngle();
    }

}
