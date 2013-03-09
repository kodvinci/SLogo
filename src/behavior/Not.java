package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Not extends OneParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return getMyValue() != 0 ? 0 : 1;
    }

}
