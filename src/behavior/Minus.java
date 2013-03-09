package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Minus extends OneParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        inverseMyValue();
        return getMyValue();
    }

}
