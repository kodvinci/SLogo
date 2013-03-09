package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Quotient extends TwoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        int result = (int) getMyFirstValue() / (int) getMySecondValue();
        return result;
    }

}
