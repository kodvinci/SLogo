package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * Moves Back
 * 
 * @author Richard Yang
 * 
 */
public class Back extends Forward {
    
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        inverseMyValue();
        super.move(model, turtleNumber);
        return getMyValue();
    }

}
