package behavior;

import exceptions.SyntaxException;
import object.Turtle;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Minus implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 1) {
            throw new SyntaxException();
        }
        return -parameters[0];
    }

}
