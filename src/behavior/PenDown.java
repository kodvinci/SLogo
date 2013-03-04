package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class PenDown implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 0)
            throw new SyntaxException();
        else {
            turtle.leftTrail();
            return 1;
        }
    }

}
