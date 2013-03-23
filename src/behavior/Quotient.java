package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Quotient extends TwoParameterCommand {

    public static final int PARAMETER_NUMBER = 3;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        int result = (int) getMyFirstValue() / (int) getMySecondValue();
        return result;
    }

}
