package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Right extends Left {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        inverseMyValue();
        super.move(model, turtleNumber);
        return getMyValue();
    }
}
