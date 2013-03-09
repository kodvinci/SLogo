package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Remainder extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        int result = (int) getMyFirstValue() % (int) getMySecondValue();
        return result;
    }

}
