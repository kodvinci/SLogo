package behavior;

import exceptions.SyntaxException;
import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class LessP extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return (getMyFirstValue() < getMySecondValue()) ? 1 : 0;
    }

}
