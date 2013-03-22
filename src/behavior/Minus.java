package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Minus extends OneParameterCommand {
    
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        inverseMyValue();
        return getMyValue();
    }

}
