package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Not extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return getMyValue() != 0 ? 0 : 1;
    }

}
