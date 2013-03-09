package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * Moves Back
 * 
 * @author Richard Yang
 * 
 */
public class Back extends Forward {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        inverseMyValue();
        super.move(model, turtleNumber);
        return getMyValue();
    }

}
