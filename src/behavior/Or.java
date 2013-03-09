package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Or extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return ((getMyFirstValue() == 0) && (getMySecondValue() == 0)) ? 0 : 1;
    }

}
