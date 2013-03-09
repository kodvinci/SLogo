package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class NotEqualP extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        return (getMyFirstValue() != getMySecondValue()) ? 1 : 0;
    }

}
