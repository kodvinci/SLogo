package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Sum extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return getMyFirstValue() + getMySecondValue();
    }

}
