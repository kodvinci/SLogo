package behavior;

import exceptions.SyntaxException;
import slogo.Model;


/**
 * Or command
 * 
 * @author Richard Yang
 * 
 */

public class Or extends TwoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return ((getMyFirstValue() == 0) && (getMySecondValue() == 0)) ? 0 : 1;
    }

}
